package weekendhomework05;

public abstract class StoryElement {
	String name;
    
	/**
	 * 
	 * @param name
	 * @param place
	 */
	public StoryElement(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 */
	public StoryElement () {
		this.name = "STElement";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName () {
		return name;
	}

}
