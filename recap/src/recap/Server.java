package recap;


public class Server extends Computer{
	public int computersMax;

	/**
	 * @return the computersMax
	 */
	public int getComputersMax() {
		return computersMax;
	}

	/**
	 * @param computersMax
	 */
	public Server(String name, char[] mac, int computersMax) {
		super(name, mac);
		this.computersMax = computersMax;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (computersMax != other.computersMax)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s ="";
		s += super.toString() + "\n";
		s += "Server max computers: " + computersMax;
		return s;
	}
	
}
