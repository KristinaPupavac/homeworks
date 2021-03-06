package weekendhomework05;

public class Event {
	public static final int DEFEAT = 0;
	public static final int FRENDSHIP = 1;
	public static final int LOVE = 2;
	public static final int REVENGE = 3;
	public static final int MANIPULATION = 4;
	
	private int event;
	
	/**
	 * @param event
	 */
	public Event(int event) {
		this.event = event;
	}

	/**
	 * @return the event
	 */
	public int getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(int event) {
		this.event = event;
	}
}