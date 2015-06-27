package homeworktrain;

/**
 * This class reperesents coloring factory and counts how much color we need to clor and drow train
 * if we want more wagons we need to add wagons
 * @author Kristina Pupavac
 *
 */
public class Dyehouse {

	public static void main(String[] args) {
		Rectangle r = new Rectangle (5, 10);
		Rectangle r1 = new Rectangle(1, 2);
		Round rou = new Round (3);
		Round rou1 = new Round (1);
		Square s = new Square (2);
		
		Wagon w1 = new Wagon (rou, r);
		Wagon w2 = new Wagon (rou, r);
		Wagon w3 = new Wagon (rou, r);
		
		Wagon[] wagons = {w1, w2, w3};
		Locomotive l = new Locomotive (rou, rou1, r, r1, s);
		Train t = new Train (l, wagons);
		
		System.out.println("Color for train drowing is: " + t.trainVolume()); 
		System.out.println("Color for train coloring is: " + t.trainArea());
		
		
		
	}

}