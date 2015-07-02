package basiccomponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task9 extends JFrame{
	private static final long serialVersionUID = -8356367935492479279L;
	private JLabel label = new JLabel ("Input folder location: ");
	private JTextField file = new JTextField();
	private JTextField fileContent = new JTextField();
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	String s = "";
	
	public Task9(){
		setLayout(new BorderLayout());
		add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new GridLayout(2, 0));
		panel1.add(label);
		panel1.add(file);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout());
		panel.add(fileContent, BorderLayout.CENTER);
		setTitle("IMPORT TEXT FILE");
		
		file.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = "";
				try {
					s = file.getText();
					TextIO.readFile(s);
					while (!TextIO.eof()) {
						text += TextIO.getln() + "\n";
					}
					fileContent.setText(text);
					add(fileContent, BorderLayout.CENTER);
					System.out.println(text);
					repaint();
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "No such file", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			
		});
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task9();

	}

}
