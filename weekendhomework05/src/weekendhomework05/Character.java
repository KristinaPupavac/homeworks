package weekendhomework05;

public class Character extends StoryElement {
	String gener;
	Boolean isAlive;
	Boolean isFit;

	/**
	 * @param name
	 * @param gener
	 * @param isAlive
	 * @param isFit
	 */
	public Character(String name, String gener, Boolean isAlive, Boolean isFit) {
		super(name);
		this.setGener(gener);
		this.setIsAlive(isAlive);
		this.setIsFit(isFit);
	}
     
	
	/**
	 * @return the gener
	 */
	public String getGener() {
		return gener;
	}


	/**
	 * @param gener the gener to set
	 */
	public void setGener(String gener) {
		this.gener = gener;
	}


	/**
	 * @return the isAlive
	 */
	public Boolean getIsAlive() {
		return isAlive;
	}

	/**
	 * @param isAlive
	 *            the isAlive to set
	 */
	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * @param isFit
	 *            the isFit to set
	 */
	public void setIsFit(Boolean isFit) {
		this.isFit = isFit;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getIsFit() {
		return isFit;
	}

	/**
	 * 
	 */
	public void killCharacter() {
		if (this.getIsAlive() == true) {
			this.setIsAlive(false);
		}
	}

	/**
	 * 
	 */
	public void makeFit() {
		if (this.getIsFit() == true) {
			this.setIsFit(false);
		}
	}

	/**
	 * 
	 */
	public String toString() {
		String s = "";
		s += "Name: " + getName() + " Gender: " + gener + " Fit: " + isFit
				+ " Alive: " + isAlive;
		return s;
	}

}