package hello.Model;

public class EmailPassPassVoter {
	
	private String email;
	private String oldPassword;
	private String newPassword;
	
	public EmailPassPassVoter(String email, String oldPassword,String newPassword) {
		super();
		this.email = email;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	
	public EmailPassPassVoter() { }
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String password) {
		this.oldPassword = password;
	}
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "VoterDto [email=" + email + ", oldPassword=" + oldPassword + "newPassword=" + newPassword + "]";
	}
}
