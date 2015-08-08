import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task2 extends JFrame {
	private static final long serialVersionUID = 1324285862448731560L;
	// Declaring variables
	private static LinkedBlockingQueue<Task> queue;
	private static ArrayList<Worker> workers;
	private static int a = 0;
	private static int b = 10;
	private static BufferedImage img = null;
	private JPanel panel;
	
	/**
	 * Default constructor 
	 */
	public Task2() {
		//Reading image from file
		try {
			img = ImageIO.read(new File("lena.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Initialization panel queue and list of workers
		panel = new MyPanel();
		queue = new LinkedBlockingQueue<Task>();
		workers = new ArrayList<>();
		add(panel);

		//Seting window
		setTitle("BUFFEREDIMAGE");
		setResizable(false);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//adding tasks to queue
		for (int i = 0; i < 51; i++) {
			queue.add(new Task(a, b));
			a += 10;
			b += 10;

		}
		
		//adding workers to list
		for (int i = 0; i < 4; i++) {
			Worker w = new Worker();
			w.start();
			try {
				w.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			workers.add(w);
		}

	}
	
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		new Task2();

	}
	
	/**
	 * Workers taking jobs until queue is empty
	 * @author KrisTina
	 *
	 */
	public static class Worker extends Thread {
		@Override
		public void run() {
			while (!queue.isEmpty()) {
				try {
					Task t = queue.take();
					t.start();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * @author KrisTina
	 *
	 */
	public static class Task extends Thread {
		private int a;
		private int b;
		
		/**
		 * Deafault constructor
		 * @param a
		 * @param b
		 */
		public Task(int a, int b) {
			this.a = a;
			this.b = b;

		}

		@Override
		public void run() {

			for (int i = a; i < b; i++) {
				for (int j = 0; j < img.getHeight(); j++) {
					int pixel = img.getRGB(i, j);
					img.setRGB(i, j, 255 - pixel);

				}
			}
		}
	}
	
	/**
	 * Drowing picture on panel
	 * @author KrisTina
	 *
	 */
	public class MyPanel extends JPanel {
		private static final long serialVersionUID = -6446634635700606218L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
			repaint();
		}
	}
}
