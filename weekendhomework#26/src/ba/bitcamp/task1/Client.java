package ba.bitcamp.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {

			Socket client = new Socket("localhost", 9966);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			Scanner input = new Scanner(System.in);
			System.out.println("Insert path: ");
			String line = input.nextLine();

			writer.write(line);
			writer.newLine();
			writer.flush();

			
			System.out.println(reader.readLine());

			input.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
