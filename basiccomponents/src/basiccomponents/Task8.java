package basiccomponents;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task8 extends JFrame {
	private static final long serialVersionUID = -4236701822200335690L;
	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JPasswordField password1 = new JPasswordField();
	private JLabel label1 = new JLabel("Username: ");
	private JLabel label2 = new JLabel("Password: ");
	private JLabel label3 = new JLabel("Repeat password: ");
	private JButton clear = new JButton("clear");
	private JButton submit = new JButton("submit");

	public Task8() {
		setLayout(new GridLayout(6, 0));
		add(label1);
		add(username);
		add(label2);
		add(password);
		add(label3);
		add(password1);
		add(clear);
		add(submit);

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String s = String.valueOf(password.getPassword());
				String s1 = String.valueOf(password1.getPassword());
				String n = username.getText();

				if (n.equals("Kristina") && n.length() > 6
						&& s.equals("kristina1234") && s.length() > 6
						&& s1.equals("kristina1234") && s1.length() > 6) {
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null,
							"Wrong username or pasword");
				}

			}
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				username.setText("");
				password.setText("");
				password1.setText("");

			}

		});

		setTitle("REGISTER FORM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Task8();

	}

}
