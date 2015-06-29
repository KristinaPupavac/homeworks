package ba.bitcamp.task2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author KrisTina
 *
 */
public class Task2 extends JFrame {
	private static final long serialVersionUID = 4358254763372349089L;

	private JButton button1 = new JButton("First Name");
	private JButton button2 = new JButton("Last Name");
	private JLabel text1 = new JLabel();
	private String s = "";
	

	/**
	 * Default constructor
	 */
	public Task2() {

		pack();
		add(button1);
		add(button2);
		add(button1, BorderLayout.WEST);
		add(button2, BorderLayout.EAST);
		Action listener = new Action();
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		text1.setHorizontalAlignment(JLabel.CENTER);
		add(text1, BorderLayout.CENTER);

		setTitle("Task2");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Inner class
	 * 
	 * @author KrisTina
	 *
	 */
	static class FirstName {
		private static String[] names = { "Ivona", "Edina", "Melisa",
				"Kristina" };

		/**
		 * Returns name from names string
		 * 
		 * @return
		 */
		static String generateName() {
			int index = (int) (Math.random() * 4);
			return names[index];
		}

		public String toString() {
			return Arrays.toString(names);
		}
	}

	/**
	 * Inner class
	 * 
	 * @author KrisTina
	 *
	 */
	static class LastName {
		private static String[] surnames = { "Malekovic", "Ibric", "Kudumovic",
				"Pupavac" };

		/**
		 * Returns surname from surnames srting
		 * 
		 * @return
		 */
		static String generateName() {
			int index = (int) (Math.random() * 4);
			return surnames[index];
		}

		public String toString() {
			return Arrays.toString(surnames);
		}
	}

	/**
	 * 
	 * @author KrisTina
	 *
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				s += Task2.FirstName.generateName() + " ";
				text1.setText(s);
			}
			if (e.getSource() == button2) {
				s += Task2.LastName.generateName();
				text1.setText(s);
				s = "";
			}
		}

	}

	public static void main(String[] args) {
		new Task2();
	}
}