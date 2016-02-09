package business.impl;

import business.CommandExecutor;
import business.VoterService;
import model.User;

public class VoterServiceImpl implements VoterService {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public User getVoterInfo(User user) {
		return (User) executor.execute(new GetUserInfoCommand(user));
	}

	@Override
	public void updatePassword() {
		// TODO Auto-generated method stub
		
	}

}
