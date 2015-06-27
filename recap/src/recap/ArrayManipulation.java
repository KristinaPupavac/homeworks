package recap;

public class ArrayManipulation {
	/**
	 * 
	 * @param computers
	 * @param index
	 */
	public static Computer[] shrinkArray(Computer[] computers, int index) {
		Computer[] c = new Computer[computers.length - 1];
		for (int i = 0; i < c.length; i++) {
			if (i != index) {
				c[i] = computers[i];
			} else if (i >= index) {
				c[i] = computers[1 + index];
			}
		}
		return c;
	}

	/**
	 * 
	 * @param computers
	 */
	public static Computer[]extendArray(Computer[] computers) {
		Computer[] c = new Computer[computers.length + 1];
		for (int i = 0; i < computers.length; i++) {
			c[i] = computers[i];
		}
		return c;
	}


}