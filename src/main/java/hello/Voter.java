package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Voter {

	@Id @GeneratedValue
	private long id;
	
	@NotNull
	private String nombre;
	@NotNull
	private String password;
	@NotNull
	private String dni;
	@NotNull
	private String email;
	private int edad;
	private long colegioelectoral;
	
	public Voter() {}

	public Voter(String nombre, String email, String password, String dni) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public long getColegioelectoral() {
		return colegioelectoral;
	}

	public void setColegioelectoral(long colegioelectoral) {
		this.colegioelectoral = colegioelectoral;
	}

	public long getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", password=" + password + ", email=" + email + ", dni=" + dni
				+ ", edad=" + edad + ", colegioelectoral=" + colegioelectoral + "]";
	}
}
