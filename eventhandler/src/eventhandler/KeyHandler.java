package eventhandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author KrisTina
 *
 */
public class KeyHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (Task1.x > 0 + Task1.size / 2) {
				Task1.x += 5;
				Task1.panel.repaint();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (Task1.x > 0 + Task1.size / 2) {
				Task1.x -= 5;
				Task1.panel.repaint();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (Task1.y > 0 + Task1.size / 2) {
				Task1.y -= 5;
				Task1.panel.repaint();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (Task1.y < Task1.heigth - Task1.size / 2) {
				Task1.y += 5;
				Task1.panel.repaint();
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
