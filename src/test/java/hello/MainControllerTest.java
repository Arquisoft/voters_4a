package hello;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Before;
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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class MainControllerTest {

    @Value("${local.server.port}")
    private int port;
    
    @Autowired
    private VoterRepository repository;

    private static final int NUM_VOTER = 4;
    private URL base;
	private RestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();
		
		for (int i = 0; i < NUM_VOTER; i++) {
			repository.save(new Voter("Nombre"+i, "Email"+i, 
					"Password"+i, "Dni"+i));
		}
	}

	@Test
	public void exitenVotantes() throws Exception {
		for (int i = 0; i < NUM_VOTER; i++) {
			assertEquals("Nombre"+i, repository.findByEmailAndPassword("Email"+i,
					"Password"+i).getNombre());
		}
	}
}


























