package homeworktrain;

/**
 * This class represents rectangle
 * 
 * @author Kristina Pupavac
 *
 */
public class Rectangle {
	 int length;
	 int weidth;

	/**
	 * Default constructor
	 * 
	 * @param length
	 *            - rectangle length
	 * @param weidth
	 *            - rectangle weidth
	 */
	public Rectangle(int length, int weidth) {
		if(length < 0 || weidth < 0){
			throw new IllegalArgumentException("Can not be negative values.");
		}
		this.length = length;
		this.weidth = weidth;
	}

	/**
	 * Returns rectangle volume
	 * 
	 * @return - rectangle volume
	 */
	public int rectangleVolume() {
		return 2 * length + 2 * weidth;
	}

	/**
	 * Returns rectangle area
	 * 
	 * @return - rectangle area
	 */
	public int rectangleArea() {
		return length * weidth;
	}

}
