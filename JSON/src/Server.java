import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import org.codehaus.jackson.map.ObjectMapper;

public class Server {

	public static void main(String[] args) {

				Random rand = new Random();
				ArrayList<String> lines = new ArrayList<>();
				ObjectMapper mapper = new ObjectMapper();
				ServerSocket server;
				try {
					server = new ServerSocket(9966);

					while (true) {
						Socket client = server.accept();
						BufferedReader reader = new BufferedReader(new FileReader(new File("lena.txt")));
						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
						
						
						String line = "";
						while ((line = reader.readLine()) != null) {
							if (!line.equals("")) {
								lines.add(line);
							}
						}

						int randomLine = rand.nextInt(lines.size());
						String message = lines.get(randomLine);

						BitResponse response = new BitResponse(message);

						mapper.writeValue(new File("test.json"), response);

						BufferedReader readerJson = new BufferedReader(new FileReader(new File("test.json")));

						writer.write(readerJson.readLine());
						writer.newLine();
						writer.flush();

						writer.close();
						reader.close();
						readerJson.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

}
