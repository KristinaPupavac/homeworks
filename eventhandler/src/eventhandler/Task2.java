package eventhandler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author KrisTina
 *
 */
public class Task2 extends JFrame{
	private static final long serialVersionUID = 5519263379851576623L;
	
	public  JPanel panel = new MyPanel1();

	private static int width = 500;
	public static int heigth = 500;
	public static int size = 100;

	public static int x = width / 2;
	public static int y = heigth / 2;

	/**
	 * Costructor
	 */
	public Task2() {
		
		add(panel);
		panel.setFocusable(true);
		panel.addKeyListener(new KeyHandler1());
		
		setTitle("Task 2");
		setSize(width, heigth);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Task2();
	}
	
	/**
	 * 
	 * @author KrisTina
	 *
	 */
	public class MyPanel1 extends JPanel {
		private static final long serialVersionUID = -6925279025154077707L;

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
	public class KeyHandler1 implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
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

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	

}
