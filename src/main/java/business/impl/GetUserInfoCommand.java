package business.impl;

import business.Command;
import model.User;
import persistence.util.Jpa;

public class GetUserInfoCommand implements Command {
	
	private User user;
	
	public GetUserInfoCommand(User user) {
		this.user = user;
	}

	@Override
	public Object execute() {
		Jpa.getManager().persist(user);
		return user;
	}
}
