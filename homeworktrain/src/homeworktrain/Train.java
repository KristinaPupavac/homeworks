package homeworktrain;

/**
 * This class represente train. Train consist locomotive and wagon.
 * 
 * @author Kristina Pupavac
 *
 */
public class Train {
	Locomotive locomotive;
	Wagon[] wagon;

	/**
	 * Default constructor
	 * 
	 * @param locomotive
	 * @param wagon
	 */
	public Train(Locomotive locomotive, Wagon[] wagon) {
		this.locomotive = locomotive;
		this.wagon = wagon;
	}

	/**
	 * Returns train volume
	 * 
	 * @return
	 */
	public double trainVolume() {
		double volume = locomotive.locomotiveVolume();
		for (int i = 0; i < wagon.length; i++) {
		volume += wagon[i].wagonVolume();
		}
		return volume;
	}

	/**
	 * Returns train area
	 * 
	 * @return
	 */
	public double trainArea() {
		double area = locomotive.locomotiveArea();
		for (int i = 0; i < wagon.length; i++) {
			area += wagon[i].wagonArea();
		}
		return area;
	}
}