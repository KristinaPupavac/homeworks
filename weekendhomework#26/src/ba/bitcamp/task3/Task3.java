package ba.bitcamp.task3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task3 extends JFrame {
	private static final long serialVersionUID = 8521458563230424401L;

	private static JLabel label = new JLabel();
	private static JButton button = new JButton("STOP");
	private Thread thread;
	private static boolean running = true;
	public static String s = "";

	public Task3() {
		thread = new MyThread();
		thread.start();

		setLayout(new GridLayout(1, 2));
		add(label);
		add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				running = false;
			}
		});

		setVisible(true);
		setSize(600, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Task3();

	}

	public static class MyThread extends Thread {

		@Override
		public void run() {

			int letter = 97;

			while (running && letter <= 123) {
				s += (char) letter++;

				label.setText(s);

				if (letter == 123) {
					letter = 97;
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
