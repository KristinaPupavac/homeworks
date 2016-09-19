package ba.bitcamp.task1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * 
 * @author KrisTina
 *
 */
public class Taks1 extends JFrame {
	private static final long serialVersionUID = -5211565197410490658L;
	private JButton[] buttons = new JButton[10];
	private String[] textOnButtons = { "0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9" };
	private String sum = "";
	private int counter = 0;

	/**
	 * Default constructor
	 */
	public Taks1() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(textOnButtons[i]);
			add(buttons[i]);
			Action listener = new Action();
			buttons[i].addActionListener(listener);
		}

		setLayout(new GridLayout(10, 1, 10, 10));
		setTitle("Task1");
		pack();
		setLocationRelativeTo(null);
		setSize(300, 300);
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
			if (counter < 3) {
				for (int i = 0; i < buttons.length; i++) {
					if (e.getSource() == buttons[i]) {
						sum += textOnButtons[i];
					}
				}
				counter++;
				if (counter == 3) {
					JOptionPane.showMessageDialog(null, "Number: " + sum);
					System.exit(0);
					sum = "";
					counter = 0;
				}
			}

		}

	}

	public static void main(String[] args) {
		new Taks1();

	}
}