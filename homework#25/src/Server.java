import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9966);
			Socket client = server.accept();

			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("links.txt"), true));
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

			String line = "";
			String link = "";
			String name = "";

			while ((line = reader.readLine()) != null) {
				if (line.contains(".")) {
					link = line.substring(0, line.indexOf(" "));
					name = line.substring(line.indexOf(" ") + 1, line.length());
				}

				writer.newLine();

				if (!link.contains("www.")) {
					writer.write("www." + link + " " + name);
				} else {
					writer.write(link + " " + name);
				}
				writer.flush();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
