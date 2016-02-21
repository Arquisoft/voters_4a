package asw.Model;

import asw.util.MD5;

public class EmailPassPassVoter {
	
	private String email;
	private String oldPassword;
	private String newPassword;
	
	/**
	 * Constructor de la clase EmailPassPassVoter.
	 * @param email, email del votante.
	 * @param oldPassword, contraseña del votante que se va a sustituir. 
	 * @param newPassword, contraseña por la que se va a reemplazar la existente.
	 */
	public EmailPassPassVoter(String email, String oldPassword,String newPassword) {
		super();
		this.email = email;
		this.oldPassword = MD5.getMD5(oldPassword);
		this.newPassword = MD5.getMD5(newPassword);
	}
	
	/**
	 * Constructor de la clase EmailPassPassVoter sin parámetros.
	 */
	public EmailPassPassVoter() { }
	
	/**	
	 * Método de acceso a la propiedad email de la clase Voter.
	 * @return String con el email del votante.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Método de modificación de la propiedad email de la clase voter.
	 * @param email, String con el email del votante.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Método de acceso a la propiedad oldPassword de la clase Voter.
	 * @return String con la contraseña actual del votante.
	 */
	public String getOldPassword() {
		return oldPassword;
	}
	
	/**
	 * Método de modificación de la propiedad oldPassword de la clase voter.
	 * @param oldPassword, String con la contraseña actual del votante.
	 */
	public void setOldPassword(String password) {
		this.oldPassword = password;
	}
	
	/**
	 * Método de acceso a la propiedad newPassword de la clase Voter.
	 * @return String con la contraseña nueva del votante.
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Método de modificación de la propiedad newPassword de la clase voter.
	 * @param oldPassword, String con la contraseña nueva del votante.
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VoterDto [email=" + email + ", oldPassword=" + oldPassword + "newPassword=" + newPassword + "]";
	}
}
