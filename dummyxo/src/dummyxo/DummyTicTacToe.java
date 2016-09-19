package dummyxo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Simulation dummy tic-tac-toe
 * @author KrisTina
 *
 */
public class DummyTicTacToe extends JFrame {
	private static final long serialVersionUID = -3135783235673695827L;
	private JButton[] buttons = new JButton[9];
	private int counter = 0;
	private int sign = 0;
	
	/**
	 * Default constructor
	 */
	public DummyTicTacToe() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			add(buttons[i]);
			buttons[i].setEnabled(true);
			Action listener = new Action();
			buttons[i].addActionListener(listener);
		}

		setLayout(new GridLayout(3, 3, 10, 10));
		setTitle("Dummy X - O");
		pack();
		setLocationRelativeTo(null);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			counter++;
			for (int i = 0; i < buttons.length; i++) {
				if (buttons[i] == e.getSource()) {
					if (sign % 2 == 0) {
						buttons[i].setText("X");
					} else {
						buttons[i].setText("O");
						buttons[i].setEnabled(false);
					}
				}
			}
			if (counter >= buttons.length) {
				JOptionPane.showMessageDialog(null, "End of game.");
				for (int j = 0; j < buttons.length; j++) {
					buttons[j].setText("");
					buttons[j].setEnabled(true);
				}
				counter = 0;
				sign = 0;
				return;
			}
			sign++;
		}
		
	}

	public static void main(String[] args) {
		new DummyTicTacToe();
	}

}