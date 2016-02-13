package hello;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import hello.DBRepository.VoterRepository;
import hello.Model.Voter;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class VoterRepositoryTest {

    @Value("${local.server.port}")
    private int port;
    
    @Autowired
    private VoterRepository repository;

    private static final int NUM_VOTER = 4;

	@Before
	public void setUpBefore() throws Exception {
		for (int i = 0; i < NUM_VOTER; i++) {
			repository.save(new Voter("Nombre"+i, "Email"+i, 
					"Password"+i, "Dni"+i));
		}
	}
	
	@After
	public void setUpAfter() throws Exception {
		repository.deleteAll();
	}
	
	@Test
	public void testExist() throws Exception {
		for (int i = 0; i < NUM_VOTER; i++) {
			assertEquals("Nombre"+i, repository.findByEmailAndPassword("Email"+i,
					"Password"+i).getNombre());
		}
	}
	
	@Test
	public void testUpdate() throws Exception {
		assertEquals(4,repository.count());
		Voter votante = repository.findByEmailAndPassword("Email1",
				"Password1");
		assertEquals("Nombre1", votante.getNombre());
		votante.setPassword("12");
		votante=repository.save(votante);
		assertEquals(4,repository.count());
		assertEquals(votante, repository.findByEmailAndPassword("Email1",
				"12"));
	}
}


























