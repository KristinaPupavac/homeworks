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
	private JButton button1 = new JButton("Char: K");
	private JButton button2 = new JButton("Insert");
	private JButton button3 = new JButton(">");
	private JButton button4 = new JButton("<");
	private JLabel text = new JLabel("_");
	String s = "";
	int index;
	private Character selectedCharacter = 'k';

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
				selectedCharacter = (char) ((int) (Math.random() * (123 - 97)) + 97);

				button1.setText("Char: " + selectedCharacter);
			} else if (e.getSource() == button2) {
				String s1 = s.substring(0, index);
				String s2 = selectedCharacter + "";
				if (index != s.length()) {
					s2 += s.substring(index);
				}

				s = s1 + s2;
				text.setText(s1 + "_" + s2);

			} else if (e.getSource() == button3) {
				if (index < s.length()) {
					index++;
					String s1 = s.substring(0, index);
					String s2 = s.substring(index);

					text.setText(s1 + "_" + s2);
				}

			} else if (e.getSource() == button4) {
				index = text.getText().indexOf("_");
				if (index > 0) {
					index--;
					String s1 = s.substring(0, index);
					String s2 = s.substring(index);

					text.setText(s1 + "_" + s2);
				}
			}
		}

	}

	public static void main(String[] args) {
		new Task4();
	}

}
