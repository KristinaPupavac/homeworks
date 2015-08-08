import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

public class Client {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		ArrayList<BitResponse> responses = new ArrayList<>();

		try {
			Socket client = new Socket("localhost", 9966);
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("test.json"), true));

			writer.write(reader.readLine());
			writer.newLine();
			writer.flush();
			writer.close();

			BufferedReader readerJson = new BufferedReader(new FileReader(new File("test.json")));

			while (readerJson.ready()) {

				BitResponse response = mapper.readValue(readerJson.readLine(), BitResponse.class);
				responses.add(response);
			}
			readerJson.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
