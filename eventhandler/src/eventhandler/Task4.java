package eventhandler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task4 extends JFrame {
	private static final long serialVersionUID = -1987740942587718517L;

	public JPanel panel = new MyPanel1();

	private static int width = 500;
	public static int heigth = 500;
	public static int size = 100;

	public static int x = width / 2;
	public static int y = heigth / 2;

	/**
	 * Costructor
	 */
	public Task4() {
		add(panel);
		panel.setFocusable(true);
		panel.addKeyListener(new KeyHandler1());

		setTitle("Task 4");
		setSize(width, heigth);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task4();
	}

	/**
	 * 
	 * @author KrisTina
	 *
	 */
	public class MyPanel1 extends JPanel {
		private static final long serialVersionUID = 5229239114063759086L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.PINK);
			g.fillOval(x - size / 2, y - size / 2, size, size);
		}
	}

	/**
	 * 
	 * @author KrisTina
	 *
	 */
	class KeyHandler1 extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (x > 0 + size / 2) {
					x += 5;
					panel.repaint();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (x > 0 + size / 2) {
					x -= 5;
					panel.repaint();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (y > 0 + size / 2) {
					y -= 5;
					panel.repaint();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (y < heigth - size / 2) {
					y += 5;
					panel.repaint();
				}
			}

		}

	}

}
