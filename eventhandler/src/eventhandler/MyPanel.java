package eventhandler;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * @author KrisTina
 *
 */
public class MyPanel extends JPanel {
	private static final long serialVersionUID = 5043950729045727054L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.PINK);
		g.fillOval(Task1.x - Task1.size / 2, Task1.y - Task1.size / 2,
				Task1.size, Task1.size);
	}
}