package arrayprocessing;

public class DynamicDouble {
	private double myArray[];
	private int count;

	/**
	 * Empty array constructor
	 */
	public DynamicDouble() {
		this(8);
	}

	/**
	 * Constructor with number of array elenemts
	 * 
	 * @param n
	 *            - number of array elements
	 */
	public DynamicDouble(int n) {
		this(n, 0.0);
		this.count = 0;
	}

	/**
	 * Constructor with number of array elenemts and value of elements
	 * 
	 * @param n
	 *            - number of array elements
	 * @param x
	 *            - element value
	 */
	public DynamicDouble(int n, double x) {
		super();
		this.myArray = new double[n];
		this.count = n;

		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = x;
		}
	}

	/**
	 * 
	 * @return
	 */
	public double[] getMyArray() {
		return myArray;
	}

	/**
	 * 
	 * @param myArray
	 */
	public void setMyArray(double[] myArray) {
		this.myArray = myArray;
	}

	/**
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Adding element to array
	 * 
	 * @param x
	 *            - element we want to add in array
	 */
	public void addElement(double x) {
		if (count >= myArray.length) {
			double tmp[] = myArray;
			myArray = new double[myArray.length * 2 + 1];
			for (int i = 0; i < tmp.length; i++) {
				myArray[i] = tmp[i];
			}
		} else {
			myArray[count] = x;
			count++;
		}
	}

	/**
	 * Adding array of elemets in array
	 * 
	 * @param array
	 *            - array of elemets we want to add
	 */
	public void addArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			addElement(array[i]);
		}
	}

	/**
	 * Number of non empty elements in array
	 * 
	 * @return
	 */
	public int size() {
		return count;
	}

	/**
	 * Number of total array size
	 * 
	 * @return
	 */
	public int totalSize() {
		return myArray.length;
	}

	/**
	 * Priniting arrray
	 * 
	 * @return - string
	 */
	public String toString() {
		String s = size() + "\t[";
		for (int i = 0; i < count; i++) {
			s += myArray[i] + " ";
		}
		s += "]\n" + totalSize() + "\t[";
		for (int i = 0; i < myArray.length; i++) {
			s += myArray[i] + " ";
		}
		s += "]\n";
		return s;
	}

	/**
	 * Remove element on input index from array
	 * 
	 * @param offset
	 *            - element inedx
	 * @throws IllegalArgumentException
	 *             - if no index in array throws exception
	 */
	public void removQuick(int offset) throws IllegalArgumentException {
		if (count == 0) {
			throw new IndexOutOfBoundsException();
		}
		if (offset >= count) {
			throw new IndexOutOfBoundsException();
		}

		myArray[offset] = myArray[count - 1];
		count--;
		if (count <= myArray.length / 3) {
			double[] tmp = new double[totalSize() / 2];
			for (int i = 0; i < tmp.length; i++) {
				tmp[i] = myArray[i];
				myArray = tmp;
			}
		}
	}

	/**
	 * Removing element form array, and shifting all elemtst to the left
	 */
	public void removSlow(int offset) throws IllegalArgumentException {
		if (offset >= count) {
			throw new IllegalArgumentException();
		}
		for (int i = offset; i < count - 1; i++) {
			myArray[i] = myArray[i + 1];
		}
		count--;
		if (count <= myArray.length / 3) {
			double[] tmp = new double[myArray.length / 2];
			for (int i = 0; i < count; i++) {
				tmp[i] = myArray[i];
			}
			myArray = tmp;
		}
	}
}
