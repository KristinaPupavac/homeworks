package weekendhomework05;

public class Goal extends StoryElement {
	public static final int EASY = 0;
	public static final int DIFFICULT = 1;
	public static final int IMPOSSIBLE = 2;
	
	private int heaviness;
	private Event event;
	private Character characterWithHappends;
	
	/**
	 * @param name
	 * @param heaviness
	 * @param event
	 * @param character
	 */
	public Goal( int heaviness, Event event, Character characterWithHappends) {
		this.heaviness = heaviness;
		this.event = event;
		this.characterWithHappends = characterWithHappends;
	}
	
	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @return the characterWithHappends
	 */
	public Character getCharacterWithHappends() {
		return characterWithHappends;
	}


	/**
	 * @param characterWithHappends the characterWithHappends to set
	 */
	public void setCharacterWithHappends(Character characterWithHappends) {
		this.characterWithHappends = characterWithHappends;
	}

	/**
	 * @return the heaviness
	 */
	public int getHeaviness() {
		return heaviness;
	}

	/**
	 * @param heaviness the heaviness to set
	 */
	public void setHeaviness(int heaviness) {
		this.heaviness = heaviness;
	}



	/**
	 * 
	 */
	public String getName() {
		return name;
	}

}
