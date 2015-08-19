import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class counting repeting of first letter in file
 * @author KrisTina
 *
 */
public class Task1 {
	//Declaring variables
	public static Integer letterCounter = 0;
	private static LinkedBlockingQueue<Task> queue;
	private static BufferedReader reader;
	private static String line = "";
	private static String firstLetter = " ";

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		queue = new LinkedBlockingQueue<>();
		File file = new File("text.txt");

		try {
			reader = new BufferedReader(new FileReader(file));
			
			while ((line = reader.readLine()) != null) {
				firstLetter = line.charAt(0) + "";

				Task task = new Task(line);
				queue.add(task);
			}

			Worker w = new Worker();
			w.start();

			try {
				w.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			System.out.println("Number of first letters in file: " + letterCounter);
			System.out.println(System.currentTimeMillis() - time + " [ms]");

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Class that represents job
	 * @author KrisTina
	 *
	 */
	public static class Task extends Thread {
		String line;

		public Task(String line) {
			this.line = line;
		}

		@Override
		public void run() {	
			for (int i = 0; i < line.length(); i++) {
				if ((line.charAt(i) + "").equalsIgnoreCase(firstLetter)) {
					synchronized (letterCounter) {
						letterCounter++;
					}
				}
			}
		}
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
					t.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
