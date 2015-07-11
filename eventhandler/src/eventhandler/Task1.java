package eventhandler;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * 
 * @author KrisTina
 *
 */
public class Task1 extends JFrame {
	private static final long serialVersionUID = -6205830863964481349L;
	
	public static JFrame frame = new JFrame();
	public static JPanel panel = new MyPanel();

	private static int width = 500;
	public static int heigth = 500;
	public static int size = 100;

	public static int x = width / 2;
	public static int y = heigth / 2;

	public Task1() {

		add(panel);
		panel.setFocusable(true);
		
		panel.addKeyListener(new KeyHandler());
		
		setTitle("Task 1");
		setSize(width, heigth);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task1();
	}

}
