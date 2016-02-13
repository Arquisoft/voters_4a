package hello.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.DBRepository.GetVoter;
import hello.DBRepository.VoterRepository;
import hello.DBRepository.Impl.GetVoterImpl;
import hello.Model.EmailCodigoVoter;
import hello.Model.EmailPassVoter;
import hello.Model.Voter;

@Controller
public class VoterController {
	
	@Autowired
	private VoterRepository voterRepo;
    
    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ResponseBody
    private ResponseEntity<EmailCodigoVoter> findUserPasswordEmail(
    		@RequestBody EmailPassVoter voterdto) {
    	voterRepo.save(new Voter("Jose", "jose@gmail.com", "jj", "1234"));
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
    
    @RequestMapping(value="/prueba", method=RequestMethod.GET)
    @ResponseBody
    private String prueba() {
    	return "Ola";
    }
}