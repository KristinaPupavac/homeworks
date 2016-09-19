package ba.bitcamp.task3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author KrisTina
 *
 */
public class Task3 extends JFrame {
	private static final long serialVersionUID = 7011918644363196576L;
	private JButton[] buttons = new JButton[10];
	private String[] textOnButtons = { "0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9" };
	private int counter = 0;
	private int[] sum = new int[5];

	/**
	 * Default constructor
	 */
	public Task3() {

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(textOnButtons[i]);
			add(buttons[i]);
			Action listener = new Action();
			buttons[i].addActionListener(listener);
		}

		pack();
		setLayout(new GridLayout(2, 5, 10, 10));
		setTitle("Task3");
		setLocationRelativeTo(null);
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * 
	 * @author KrisTina
	 *
	 */
	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (counter < 5) {
				for (int i = 0; i < buttons.length; i++) {
					if (i + 5 < buttons.length) {
						if (e.getSource() == buttons[i]) {
							buttons[i + 5].setEnabled(false);
							sum[i] = Integer.parseInt(textOnButtons[i]);
						} else if (e.getSource() == buttons[i + 5]) {
							buttons[i].setEnabled(false);
							sum[i] = Integer.parseInt(textOnButtons[i + 5]);
						}
					}
				}
			}
			counter++;
			if (counter == 5) {
				JOptionPane.showMessageDialog(null, Arrays.toString(sum));
				System.exit(0);
				sum = new int[5];
				counter = 0;
			}

		}

	}

	public static void main(String[] args) {
		new Task3();

	}

}
