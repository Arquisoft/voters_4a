package persistence;
import java.util.List;

import model.User;
import persistence.util.Jpa;

public class UserFinder {

	public static User findUser(String dni, String passwd) {
		List<User> ulist = Jpa.getManager().createNamedQuery("User.findUser",
			      User.class)
		.setParameter(1, dni)
		.setParameter(2, passwd)
		.getResultList();
		return ulist.isEmpty() ? null : ulist.get(0);
	}
}
