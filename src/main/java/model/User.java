package model;

@Entity
@Table(name= "TUser")
public class User {
	
	@Id
	private String DNI;
	private String PASSWD;
	
	public User(){};
	
	public User(String dni,String passwd){
		this.DNI=dni;
		this.PASSWD=passwd;
	}

	public String getPASSWD() {
		return PASSWD;
	}

	public void setPASSWD(String pASSWD) {
		PASSWD = pASSWD;
	}

	public String getDNI() {
		return DNI;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((PASSWD == null) ? 0 : PASSWD.hashCode());
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
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (PASSWD == null) {
			if (other.PASSWD != null)
				return false;
		} else if (!PASSWD.equals(other.PASSWD))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return "DNI: "+DNI+"\t PASSWORD: "+PASSWD;
	}
	

}
