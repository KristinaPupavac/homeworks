package recap;

public class StartNetwork extends Network implements Functionable {
	private Server server;

	public StartNetwork(String networkName, Server sever) {
		super(networkName);
		this.server = server;
	}

	@Override
	public void addComputer(Computer c) {
		if (c instanceof Server) {
			throw new IllegalArgumentException(
					"Servers cannot be on this network.");
		} else if (c instanceof Client) {
			Client c1 = (Client) c;
			ArrayManipulation.extendArray(computers);
			c1.connect(server);
		}
	}

	@Override
	public void removeComputer(Computer c) {
		if (c instanceof Server) {
			throw new IllegalArgumentException(
					"Servers cannot be on this network.");
		} else if (c instanceof Client) {
			Client c1 = (Client) c;
			for (int i = 0; i < computers.length; i++) {
				if (computers[i] == c) {
					System.out.println("Computer: " + c + " is on network!");
					ArrayManipulation.shrinkArray(computers, i);
					c1.disconnect();
				} else {
					throw new IllegalArgumentException(
							"Computer is not on this network.");
				}
			}
		}
	}

	@Override
	public boolean isFunctioning() {
		int counter = 0;
		for (int i = 0; i < computers.length; i++) {
			if (computers[i] instanceof Client) {
				if (computers[i] != null) {
					counter++;
				}
			}
		}
		if (server.getComputersMax() < counter) {
			return false;
		} else {
			return true;
		}
	}

	public String toString() {
		String s = "";
		s += "Srever: " + server;
		return s;
	}

}
