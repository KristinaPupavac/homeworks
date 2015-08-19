package recap;

public class Client extends Computer implements Connectable{
	Computer computer;
	Network network;
	
	/**
	 * @param name
	 * @param mac
	 */
	public Client(String name, char[] mac) {
		this.name = name;
		this.mac = new MACAddress(mac);
	}

	@Override
	public void connect(Computer computer) {
		if (computer == null ) {
		this.computer = computer;
		} else {
			throw new IllegalArgumentException ("Already connected!");
		}
	}

	@Override
	public void connect(Network network) {
		if (network == null) {
		this.network = network;
		} else {
			throw new IllegalArgumentException ("Already connected!");
		}
	}

	@Override
	public void disconnect() {
		this.computer = null;
		this.network = null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (computer == null) {
			if (other.computer != null)
				return false;
		} else if (!computer.equals(other.computer))
			return false;
		if (network == null) {
			if (other.network != null)
				return false;
		} else if (!network.equals(other.network))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		s += super.toString() + "\n";
		s += "Client: \n" + "Computer: " + computer + "\nNetwork: " + network;
		return s;
	}
	
	
	


}