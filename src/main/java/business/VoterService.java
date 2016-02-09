package business;

import model.User;

public interface VoterService {

	User getVoterInfo(User user);
	void updatePassword(); 
}
