import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BitResponse {
	private String message;
	private String timestamp;

	/**
	 * 
	 */
	public BitResponse() {
		this.message = null;
		this.timestamp = null;
	}

	/**
	 * 
	 * @param message
	 * @param timestamp
	 */
	public BitResponse(String message) {
		this.message = message;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		this.timestamp = dateFormat.format(date);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Message: %s, Timestamp: %s", message, timestamp);
	}

}
