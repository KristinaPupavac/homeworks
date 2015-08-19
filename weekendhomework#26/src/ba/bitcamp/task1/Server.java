package ba.bitcamp.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9966);
			Socket client = server.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			String line = reader.readLine();
			File file = new File(line);

			if (file.exists()) {
				writer.write("1");
			} else {
				writer.write("0");
			}

			writer.newLine();
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
