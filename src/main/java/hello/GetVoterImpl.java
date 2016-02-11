package hello;

public class GetVoterImpl implements GetVoter {
	
	@Override
	public Voter findVoter(VoterRepository voterRepo, String email, 
			String password) {
		return voterRepo.findByEmailAndPassword(email, password);
	
	}

}
