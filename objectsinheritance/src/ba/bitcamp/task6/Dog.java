package ba.bitcamp.task6;

/**
 * 
 * @author KrisTina
 *
 */
public class Dog extends Pet {
	private String rase;

	/**
	 * 
	 * @param name
	 * @param year
	 * @param isDogOrCat
	 */
	public Dog(String name, Integer year, String rase) {
		super(name, year, DOG);
		this.rase = rase;
	}

	/**
	 * @return the rase
	 */
	public String getRase() {
		return rase;
	}

	/**
	 * @param rase
	 *            the rase to set
	 */
	public void setRase(String rase) {
		this.rase = rase;
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (rase == null) {
			if (other.rase != null)
				return false;
		} else if (!rase.equals(other.rase))
			return false;
		return true;
	}

	/**
	 * 
	 */
	public String toString() {
		String s = "";
		s = s + "Rase: " + rase + "\n";
		s = s + super.toString();
		return s;
	}
}
