package ba.bitcamp.task234;


/**
 * 
 * @author KrisTina
 *
 */
public class Autor {
	private String name;
	private String gener;
	private String mail;

	/**
	 * @param name
	 * @param gener
	 * @param mail
	 */
	public Autor(String name, String gener, String mail) {
		super();
		this.name = name;
		this.gener = gener;
		this.mail = mail;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gener
	 */
	public String getGener() {
		return gener;
	}

	/**
	 * @param gener
	 *            the gener to set
	 */
	public void setGener(String gener) {
		this.gener = gener;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Autor " + name + ", gener: " + gener + ", mail:" + mail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (gener == null) {
			if (other.gener != null)
				return false;
		} else if (!gener.equals(other.gener))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}