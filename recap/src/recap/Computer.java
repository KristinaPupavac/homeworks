package recap;

public class Computer {
	String name;
	MACAddress mac;

	public class MACAddress {
		char[] charArray; // 0123456789ab

		/**
		 * @param charArray
		 */
		public MACAddress(char[] charArray) {
			this.charArray = charArray;
		}

		/**
		 * @return the charArray
		 */
		public char[] getCharArray() {
			return charArray;
		}

		/**
		 * @param charArray
		 *            the charArray to set
		 */
		public void setCharArray(char[] charArray) {
			this.charArray = charArray;
		}

		@Override
		// 01:23:45:67:89:ab
		public String toString() {
			String s = "";
			int counter = 0;
			for (int i = 0; i < charArray.length; i++) {
				if (counter % 2 == 0 && counter != 0) {
					s += ":";
				}
				s += charArray[i];
				counter++;
			}
			return s;
		}

	}

	/**
	 * @param name
	 * @param mac
	 */
	public Computer(String name, char[] mac) {
		this.name = name;
		this.mac = new MACAddress(mac);
	}

	/**
	 * @param name
	 * @param mac
	 */
	public Computer() {
		this.name = "PC";
		char[] address = { 'e', '5', '6', 'w', '5', 'r', '3', '9', 'k', '3',
				't', 'i' };
		MACAddress ad = new MACAddress(address);
		this.mac = ad;
	}

	@Override
	public String toString() {
		String s = "";
		s += "Computer: " + name + "\nMAC address: " + mac;
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}