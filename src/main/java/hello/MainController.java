package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired
	private VoterRepository voterRepo;
    
    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ResponseBody
    private ResponseEntity<EmailCodigoVoter> findUserPasswordEmail(
    		@RequestBody EmailPassVoter voterdto) {
    	
    	GetVoter voterAccess = new GetVoterImpl();
    	Voter tmps = voterAccess.findVoter(voterRepo, voterdto.getEmail(),
    			voterdto.getPassword());
    
    	if (tmps != null)
    		return new ResponseEntity<EmailCodigoVoter>(new EmailCodigoVoter(
    				tmps.getEmail(), tmps.getColegioelectoral()), 
    				HttpStatus.ACCEPTED);
    	else
    		return new ResponseEntity<EmailCodigoVoter>(HttpStatus.BAD_REQUEST);
    }
}