package homeworktrain;

/**
 * This method represents Round
 * 
 * @author Kristina Pupavac
 *
 */
public class Round {
	 int radius;

	/**
	 * Default constructor
	 * 
	 * @param radius
	 *            round radius
	 */
	public Round(int radius) {
		if(radius < 0){
			throw new IllegalArgumentException("Can not be negative value.");
		}
		this.radius = radius;
	}

	/**
	 * Returns round volume
	 * 
	 * @return - round volume
	 */
	public double roundVolume() {
		return 2 * radius * Math.PI;
	}

	/**
	 * Returns round area
	 * 
	 * @return - round area
	 */
	public double roundArea() {
		return radius * radius * Math.PI;
	}

}