package ba.bitcamp.task6;

public class Cat extends Pet{
	
	/**
	 * 
	 * @param name
	 * @param year
	 */
	public Cat(String name, Integer year) {
		super(name, year, CAT);
	}
	
	/**
	 * 
	 */
	public String toString () {
		String s = "";
		s = s + super.toString();
		return s;
	}
	

}