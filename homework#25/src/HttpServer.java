import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	private static ServerSocket server = null;
	private static Socket client = null;
	private static BufferedReader htmlFileReader = null;
	private static BufferedReader textFileReader = null;
	private static BufferedWriter writer = null;
	private static String textFromFile = "";
	private static String line = "";

	public static void main(String[] args) {
		try {
			server = new ServerSocket(66);
			System.out.println("Server started.");
				
			while (true) {
				client = server.accept();

				htmlFileReader = new BufferedReader(new FileReader(new File ("links.html")));

				while (htmlFileReader.ready()) {
					textFromFile += htmlFileReader.readLine();
				}

				textFileReader = new BufferedReader(new FileReader(new File("links.txt")));

				while (textFileReader.ready()) {
					line = textFileReader.readLine();
					
				
					String link = line.substring(0, line.indexOf(" ") + 1);
					String linkName = line.substring(line.indexOf(" ") + 1, line.length());

					textFromFile += "<a href =" + link + ">" + "</a>";
					
				}

				textFromFile += "</body></html>";

				writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

				writer.write(textFromFile);
				writer.newLine();
				writer.flush();

				textFileReader.close();
				htmlFileReader.close();
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
