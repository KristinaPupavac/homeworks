package homeworktrain;

/**
 * This class represents wagon. Wagon consist two rounds and one rectangle
 * @author Kristina Pupavac
 *
 */
public class Wagon {
	 Round wheel;
	 Rectangle platform;
	
	/**
	 * Default constructor
	 * @param round
	 * @param rectangle
	 */
	public Wagon(Round round, Rectangle rectangle) {
		this.wheel = round;
		this.platform = rectangle;
	}
	
	/**
	 * 
	 * @return
	 */
	public double wagonVolume () {
		return platform.rectangleVolume() + 2 * wheel.roundVolume();
	}
	/**
	 * 
	 * @return
	 */
	public double wagonArea () {
		return platform.rectangleArea() + 2 * wheel.roundArea();
	}

}
