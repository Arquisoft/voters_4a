package hello;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import hello.DBRepository.VoterRepository;
import hello.Model.Voter;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class VoterControllerTest {

    @Value("${local.server.port}")
    private int port;
    
    private MockMvc mockMvc;
    
    @Autowired
    private VoterRepository repository;

    
    @Autowired
    private WebApplicationContext webApplicationContext;

	@Before
	public void setUpBefore() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}
	
	@After
	public void setUpAfter() throws Exception {
		repository.deleteAll();
	}
	
	@Test
	public void testVoterExists() throws Exception {
		
		repository.save(new Voter("Jose", "j","j", "1234")); 
		assertEquals(1, repository.count());
		
		mockMvc
		.perform(post("/user")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"email\":\"j\", \"password\": \"j\"}")
		).andExpect(status().is(202));
	}
	
	@Test
	public void testVoterNoExists() throws Exception {
		mockMvc
		.perform(post("/user")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"email\":\"noexiste\", \"password\": \"noexiste\"}")
		).andExpect(status().is(400));
	}
}
