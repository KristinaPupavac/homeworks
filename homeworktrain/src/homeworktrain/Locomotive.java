package homeworktrain;

/**
 * This class represents locomotive. Locomotive consist one square, two
 * different rectangles and four rounds, two for wheels and two for windows.
 * 
 * @author KrisTina
 *
 */
public class Locomotive {
	Round wheel;
	Round window;
	Rectangle platform;
	Rectangle chimney;
	Square cabin;

	/**
	 * Default constructor
	 * @param round
	 * @param rectangle
	 * @param square
	 */
	public Locomotive(Round round1, Round round2, Rectangle rectangle1,
			Rectangle rectangle2, Square square) {
		this.wheel = round1;
		this.window = round2;
		this.platform = rectangle1;
		this.chimney = rectangle2;
		this.cabin = square;
	}
    /**
     * Returns locomotive volume
     * @return
     */
	public double locomotiveVolume() {
		return 2 * wheel.roundVolume() + 2 * window.roundVolume()
				+ cabin.squareVolume() + platform.rectangleVolume()
				+ chimney.rectangleVolume();
	}
	/**
	 * Returns locomotive area
	 * @return
	 */
	public double locomotiveArea () {
		return 2 * wheel.roundArea() + 2 * window.roundArea()
				+ cabin.squareArea() + platform.rectangleArea()
				+ chimney.rectangleArea();
	}

}
