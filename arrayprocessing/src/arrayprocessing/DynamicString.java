package arrayprocessing;

public class DynamicString {
	private String myString[];
	private int count;

	/**
	 * Constructor array is empty
	 */
	public DynamicString() {
		this(0, null);
	}

	/**
	 * Constructor input array size, elements value set to null
	 * 
	 * @param size
	 */
	public DynamicString(int size) {
		this(size, null);
		count = 0;
	}

	/**
	 * Constructor need to input array size, and value of elements
	 * 
	 * @param size
	 * @param value
	 */
	public DynamicString(int size, String value) {
		super();
		count = size;
		myString = new String[size];
		for (int i = 0; i < count; i++) {
			myString[i] = value;
		}
	}

	/**
	 * @return the myString
	 */
	public String[] getMyString() {
		return myString;
	}

	/**
	 * @param myString
	 *            the myString to set
	 */
	public void setMyString(String[] myString) {
		this.myString = myString;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Adds new elemetn in array
	 * 
	 * @param value
	 *            - new element value
	 */
	public void addElement(String value) {
		if (count == myString.length) {
			String[] tmp = new String[2 * myString.length + 1];
			for (int i = 0; i < myString.length; i++) {
				tmp[i] = myString[i];
			}
			myString = tmp;
		}
		myString[count] = value;
		count++;
	}

	/**
	 * Adds an array of elements to the array.
	 * 
	 * @param array
	 *            - adding array
	 */
	public void addArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			addElement(array[i]);
		}
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return count;
	}

	/**
	 * 
	 * @return
	 */
	public int totalSize() {
		return myString.length;
	}

	/**
	 * Printing array
	 * 
	 * @return - String
	 */
	public String toString() {
		String s = size() + "\t[";
		for (int i = 0; i < count; i++) {
			s += myString[i] + " ";
		}
		s += "]\n" + totalSize() + "\t[";
		for (int i = 0; i < myString.length; i++) {
			s += myString[i] + " ";
		}
		s += "]\n";
		return s;
	}

	/**
	 * Removes the element with inputed index from the array and putting the
	 * last element that has value on place of removed element.
	 * 
	 * @param index
	 * @throws IllegalArgumentException
	 */
	public void removeQuick(int offset) throws IllegalArgumentException {
		if (offset >= count) {
			throw new IllegalArgumentException();
		}
		myString[offset] = myString[count - 1];
		count--;
		if (count <= myString.length / 3) {
			String[] tmp = new String[myString.length / 2];
			for (int i = 0; i < count; i++) {
				tmp[i] = myString[i];
			}
			myString = tmp;
		}
	}

	/**
	 * Removing element form array, and shifting all elemtst to the left
	 * 
	 * @param index
	 * @throws IllegalArgumentException
	 */
	public void removeSlow(int offset) throws IllegalArgumentException {
		if (offset >= count) {
			throw new IllegalArgumentException();
		}
		for (int i = offset; i < count - 1; i++) {
			myString[i] = myString[i + 1];
		}
		count--;
		if (count <= myString.length / 3) {
			String[] tmp = new String[myString.length / 2];
			for (int i = 0; i < count; i++) {
				tmp[i] = myString[i];
			}
			myString = tmp;
		}
	}

}
