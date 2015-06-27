package ba.bitcamp.task6;

/**
 * 
 * @author KrisTina
 *
 */
public class Pet {
	public static final int DOG = 0;
	public static final int CAT = 1;

	private int isDogOrCat;
	private String name;
	private Integer year;

	/**
	 * @param name
	 * @param year
	 */
	public Pet(String name, Integer year, int isDogOrCat) {
		super();
		this.name = name;
		this.year = year;
		this.isDogOrCat = isDogOrCat;
	}

	/**
	 * @return the isDogOrCat
	 */
	public int getIsDogOrCat() {
		return isDogOrCat;
	}

	/**
	 * @param isDogOrCat
	 *            the isDogOrCat to set
	 */
	public void setIsDogOrCat(int isDogOrCat) {
		this.isDogOrCat = isDogOrCat;
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
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @return the dog
	 */
	public static int getDog() {
		return DOG;
	}

	/**
	 * @return the cat
	 */
	public static int getCat() {
		return CAT;
	}

	/* (non-Javadoc)
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
		Pet other = (Pet) obj;
		if (isDogOrCat != other.isDogOrCat)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	/**
	 * 
	 */
	public String toString() {
		String s = "Pet: \n";
		s = s + "Name: " + name + " Year: " + year + "\n";
		if (isDogOrCat == Pet.DOG) {
			s = s + "Aw aw";
		} else if (isDogOrCat == Pet.CAT) {
			s = s + "Go away human";
		}
		return s;
	}

}
