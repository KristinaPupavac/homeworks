package homeworktrain;

/**
 * This class represents square
 * 
 * @author Kristina Pupavac
 *
 */
public class Square {
	 int page;

	/**
	 * Default constructor consist square page
	 * 
	 * @param page
	 */
	public Square(int page) {
		if(page < 0){
			throw new IllegalArgumentException("Can not be negative values");
		}
		this.page = page;
	}

	/**
	 * Method returns square volume
	 * 
	 * @return square volume
	 */
	public int squareVolume() {
		return 4 * page;
	}

	/**
	 * Method returns square area
	 * 
	 * @return square area
	 */
	public int squareArea() {
		return page * page;
	}
}