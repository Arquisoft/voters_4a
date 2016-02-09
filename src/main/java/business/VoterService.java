package business;

import model.User;

public interface VoterService {

	User getVoterInfo(String dni, String passwd);
	void updatePassword(); 
}
