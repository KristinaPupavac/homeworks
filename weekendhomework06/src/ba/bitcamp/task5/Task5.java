package ba.bitcamp.task5;

/**
 * 
 * @author KrisTina
 *
 */
public class Task5 {
	/**
	 * Methode with recursion
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getPower(int a, int b) {
		if (b > 0) {
			if (b == 1) {
				return a;
			}
			if (b == 1 && a < 0 && b % 2 == 0) {
				return a = -1 * a;
			}
			return a * getPower(a, b - 1);

		} else {
			if (b == -1 && a < 0 && b % 2 == 0) {
				return a = -1 * a;
			}
			return a / getPower(a, -b + 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(getPower(2, 5));
		System.out.println(getPower(-2, 4));
		System.out.println(getPower(-2, -2));
	}

}
