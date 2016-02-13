package hello.DBRepository.Impl;

import hello.DBRepository.GetVoter;
import hello.DBRepository.VoterRepository;
import hello.Model.Voter;

public class GetVoterImpl implements GetVoter {
	
	@Override
	public Voter findVoter(VoterRepository voterRepo, String email, 
			String password) {
		return voterRepo.findByEmailAndPassword(email, password);
	
	}

}
