package hello;

public interface GetVoter {

	Voter findVoter(VoterRepository voterRepo, String email, String password);
}
