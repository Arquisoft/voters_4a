package hello.Model;

public class EmailPassVoter {
	
	private String email;
	private String password;
	
	public EmailPassVoter(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public EmailPassVoter() { }
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "VoterDto [email=" + email + ", password=" + password + "]";
	}
}
