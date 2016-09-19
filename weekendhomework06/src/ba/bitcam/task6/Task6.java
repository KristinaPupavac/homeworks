package ba.bitcam.task6;

/**
 * 
 * @author KrisTina
 *
 */
public class Task6 {
	/**
	 * Metode with recursion
	 * 
	 * @param matrix
	 */
	public static void fillArray(int[][] matrix) {
		fillArray(matrix, 0, 0, 0);
	}

	public static void fillArray(int[][] matrix, int index1, int index2, int n) {
		if (index1 == matrix.length) {
			return;
		}
		if (index2 == matrix[index1].length - 1) {
			matrix[index1][index2] = n;
			fillArray(matrix, index1 + 1, 0, n + 1);
		} else {
			matrix[index1][index2] = n;
			fillArray(matrix, index1, index2 + 1, n + 1);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][5];

		fillArray(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
