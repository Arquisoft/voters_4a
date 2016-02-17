package asw.Controller;
//modelo.attribute
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import asw.DBRepository.GetVoter;
import asw.DBRepository.VoterRepository;
import asw.DBRepository.Impl.GetVoterImpl;
import asw.Model.EmailCodigoVoter;
import asw.Model.EmailPassPassVoter;
import asw.Model.EmailPassVoter;
import asw.Model.Voter;

@Controller
public class VoterController {
	
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
	
    @RequestMapping(value="/password", method=RequestMethod.POST)
    @ResponseBody
    private ResponseEntity<EmailPassVoter> changeUserPassword(
    		@RequestBody EmailPassPassVoter voterdto) {   	
    	GetVoter voterAccess = new GetVoterImpl();
    	Boolean correct = voterAccess.ChangePasswordVoter(voterRepo, voterdto.getEmail(),
    			voterdto.getOldPassword(), voterdto.getNewPassword());
    	
    	if (correct == true)
    		return new ResponseEntity<EmailPassVoter>(new EmailPassVoter(
    				voterdto.getEmail(), voterdto.getNewPassword()), 
    				HttpStatus.ACCEPTED);
    	else
    		return new ResponseEntity<EmailPassVoter>(HttpStatus.BAD_REQUEST);
    }
    
}