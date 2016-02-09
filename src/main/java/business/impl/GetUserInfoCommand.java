package business.impl;

import business.Command;
import persistence.UserFinder;

public class GetUserInfoCommand implements Command {
	
	private String dni;
	private String passwd;
	
	public GetUserInfoCommand(String dni, String passwd) {
		this.dni = dni;
		this.passwd = passwd;
	}

	@Override
	public Object execute() {
		return UserFinder.findUser(dni, passwd);
	}
}
