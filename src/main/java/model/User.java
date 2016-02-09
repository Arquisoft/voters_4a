package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TUser")
public class User {
	
	@Id @GeneratedValue
	private String dni;
	private String passwd;
	
	public User(){};
	
	public User(String dni, String passwd){
		this.dni=dni;
		this.passwd=passwd;
	}

	public String getPASSWD() {
		return passwd;
	}

	public void setPASSWD(String pASSWD) {
		passwd = pASSWD;
	}

	public String getDNI() {
		return dni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
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
		User other = (User) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return "DNI: "+dni+"\t PASSWORD: "+passwd;
	}
}
