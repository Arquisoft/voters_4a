package asw.Model;

public class EmailCodigoVoter {
	
	private long colegioelectoral;
	private String email;
	
	public EmailCodigoVoter(String email, long colegioelectoral) {
		this.email = email;
		this.colegioelectoral = colegioelectoral;
	}
	@Override
	public String toString() {
		return "EmailCodigoVoter [colegioelectoral=" + colegioelectoral + ", email=" + email + "]";
	}
	public long getColegioelectoral() {
		return colegioelectoral;
	}
	public void setColegioelectoral(long colegioelectoral) {
		this.colegioelectoral = colegioelectoral;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
