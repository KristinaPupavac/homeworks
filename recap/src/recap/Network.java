package recap;

public abstract class Network {
	public String networkName;
	public Computer[] computers;

	/**
	 * @param networkName
	 * @param computers
	 */
	public Network(String networkName) {
		this.networkName = networkName;
		Computer[] c = new Computer[0];
		this.computers = c;
	}

	public abstract void addComputer(Computer c);

	public abstract void removeComputer(Computer c);
}