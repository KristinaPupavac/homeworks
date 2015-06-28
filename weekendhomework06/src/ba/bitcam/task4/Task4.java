package ba.bitcam.task4;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author KrisTina
 *
 */
public class Task4 extends JFrame {
	private static final long serialVersionUID = 3892600312934552127L;
	private JButton button1 = new JButton("Char: ");
	private JButton button2 = new JButton("Insert");
	private JButton button3 = new JButton(">");
	private JButton button4 = new JButton("<");
	private JLabel text = new JLabel("_");
	private String[] characters = { "K", "R", "I", "S", "T", "I", "N", "A" };
	String s = "";
	int index;

	/**
	 * Default constructor
	 */
	public Task4() {
		setLayout(new BorderLayout());

		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(button3, BorderLayout.EAST);
		add(button4, BorderLayout.WEST);
		Action listener = new Action();
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		button3.addActionListener(listener);
		button4.addActionListener(listener);

		add(text, BorderLayout.CENTER);
		text.setHorizontalAlignment(NORMAL);

		pack();
		setVisible(true);
		setSize(400, 300);
		setTitle("Task4");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 
	 * @author KrisTina
	 *
	 */
	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				text.setText("Char: "
						+ characters[(int) Math.random() * characters.length]);

			} else if (e.getSource() == button2) {
				index = text.getText().indexOf("_");
				s = text.getText().substring(0, index)
						+ button1.getText()
						+ "_"
						+ text.getText().substring(index + 1,
								text.getText().length());
				text.setText(s);

			} else if (e.getSource() == button3) {
				index = text.getText().indexOf("_");
				s = text.getText().substring(0, index)
						+ text.getText().substring(index + 1, index + 2)
						+ "_"
						+ text.getText().substring(index + 2,
								text.getText().length());
				text.setText(s);

			} else if (e.getSource() == button4) {
				index = text.getText().indexOf("_");
				s = text.getText().substring(0, index - 1)
						+ "_"
						+ text.getText().substring(index - 1, index)
						+ text.getText().substring(index + 1,
								text.getText().length());
				text.setText(s);
			}
		}

	}

	public static void main(String[] args) {
		new Task4();
	}

}
