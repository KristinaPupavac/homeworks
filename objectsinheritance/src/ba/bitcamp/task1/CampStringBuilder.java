package ba.bitcamp.task1;

/**
 * 
 * @author KrisTina
 *
 */
public class CampStringBuilder {
	private char[] characters;

	/**
	 * @param characters
	 */
	public CampStringBuilder(char[] characters) {
		super();
		this.characters = characters;
	}

	/**
	 * 
	 * @param o
	 */
	public void append(Object o) {
		System.out.println(this.toString() + o.toString());
	}

	/**
	 * 
	 * @param o
	 */
	public void prepend(Object o) {
		System.out.println(o.toString() + this.toString());
	}

	/**
	 * 
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < characters.length; i++) {
			s = s + characters[i];
		}
		return s;

	}

}