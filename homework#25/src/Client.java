import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {

			Socket client = new Socket("localhost", 9966);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			Scanner input = new Scanner(System.in);
			System.out.println("Enter link and link name: ");
			String line = input.nextLine();

			while (true) {
				if (line.length() > 0 && line.contains(" ")) {
					writer.newLine();
					writer.write(line);
					writer.close();
				} else {
					System.out.println("there is no such link");
					line = input.nextLine();
				}

			}

		} catch (IOException e) {

		}

	}

}
