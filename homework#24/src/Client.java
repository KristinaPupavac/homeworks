import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Client extends JFrame {
	private static final long serialVersionUID = 6463534731269380864L;
	// Declaring frame elements
	private JTextField text = new JTextField();
	private JTextArea area = new JTextArea();
	private JButton button = new JButton("SEND");
	private JScrollPane scrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

	// Declaring sockets, buffer writer and reader
	private String line = "";
	BufferedWriter writer = null;
	BufferedReader reader = null;
	Socket client = null;

	/**
	 * Client constructor allows clients to send and receive messages
	 */
	public Client() {
		button.addActionListener(new ButtonHandler());
		text.addActionListener(new ButtonHandler());

		setTitle("CLIENT");
		setLayout(new GridLayout(2, 1));
		add(panel1);
		add(panel2);
		panel1.setLayout(new BorderLayout());
		panel1.add(area, BorderLayout.CENTER);
		panel1.add(scrollPane, BorderLayout.EAST);
		panel2.setLayout(new BorderLayout());
		panel2.add(text, BorderLayout.CENTER);
		panel2.add(button, BorderLayout.EAST);

		area.setEditable(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setEnabled(true);

		setVisible(true);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			client = new Socket("localhost", 9966);
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

			// Reading sent messages.
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("/web")) {
					try {
						Desktop.getDesktop()
								.browse(new URI("http://" + line.substring(line.indexOf(" ") + 1, line.length())));
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				} else if (line.startsWith("/open")) {
					String filePath = line.substring(line.indexOf(" ") + 1, line.length());
					Desktop.getDesktop().open(new File(filePath));

				} else if (line.startsWith("/delete")) {
					String path = line.substring(line.indexOf(" ") + 1, line.length());
					File file = new File(path);
					file.delete();

				} else if (line.startsWith("/list")) {
					String filePath = line.substring(line.indexOf(" ") + 1, line.length());
					File file = new File(filePath);
					String[] fileList = file.list();
					for (int i = 0; i < fileList.length; i++) {
						area.append(fileList[i] + "\n");
					}
				} else {
					// Printing the received text on the text area.
					area.append("Client: " + line + "\n");
				}
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Class that allows you to print text to the text field on frame
	 * 
	 * @author KrisTina
	 *
	 */
	public class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				writer.write(text.getText());
				writer.newLine();
				writer.flush();

				// Writing sent message in the chat area.
				area.append("Client: " + text.getText() + "\n");
				text.setText("");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		// Callling constructor
		new Client();

	}

}
