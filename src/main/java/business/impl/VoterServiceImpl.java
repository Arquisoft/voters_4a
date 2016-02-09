package business.impl;

import business.CommandExecutor;
import business.VoterService;
import model.User;

public class VoterServiceImpl implements VoterService {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public User getVoterInfo(String dni, String passwd) {
		return (User) executor.execute(
				new GetUserInfoCommand(dni, passwd));
	}

	@Override
	public void updatePassword() {
		// TODO Auto-generated method stub
		
	}

}
