package asw.DBRepository;

import asw.Model.Voter;

public interface GetVoter {

	Voter findVoter(VoterRepository voterRepo, String email, String password);
	
	Boolean ChangePasswordVoter(VoterRepository voterRepo, String email, String oldPassword, String newPassword);
}
