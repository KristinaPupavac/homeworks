package recap;


import java.util.Arrays;

public class Main {
public static void main(String[] args) {
		
		//Computer c = new Computer();
		//System.out.println(c);
		
		char[] address = { 'e', '5', '6', 'w', '5', 'r', '3', '9', 'k', '3',
				't', 'i' };
		Server s = new Server("Server", address, 5);
		//System.out.println(s);
		
		Client c = new Client ("PC" , address);
		//System.out.println(c);
		Client c1 = new Client ("PC1" , address);
		Client c2 = new Client ("PC2" , address);
	
//		c1.disconnect();
//		System.out.println(c1);
//
//		c1.mac.charArray = address;
//		c1.name = "Novo ime";
//		
//		System.out.println(c2);
		
		StartNetwork sn = new StartNetwork("Network", s);
	
		
		Computer[] cc = new Computer[] {c, c1, c2};
//		System.out.println("niz" + Arrays.toString(cc));
//		System.out.println("smanjeni niz" + Arrays.toString(ArrayManipulation.shrinkArray(cc, 1)));
//		System.out.println("prosireni niz" + Arrays.toString(ArrayManipulation.extendArray(cc)));
		
		sn.addComputer(c1);
		sn.addComputer(c2);
		
		sn.removeComputer(c1);
		
		System.out.println(sn);

	}

}