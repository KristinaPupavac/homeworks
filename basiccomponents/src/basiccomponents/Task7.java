package basiccomponents;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task7 extends JFrame {
	private static final long serialVersionUID = -7799709622962812234L;
	private JSlider slider = new JSlider(0, 400);
	private Mypanel panel = new Mypanel();
	private int diameter = 0;
	private int x;
	private int y;

	public Task7() {
		setLayout(new BorderLayout());
		add(slider, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		slider.setValue(0);

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Graphics g = getGraphics();
				diameter = slider.getValue();
				panel.paintComponent(g);

			}
		});

		panel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Graphics g = getGraphics();
				x = e.getX();
				y = e.getY();
				panel.paintComponent(g);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		setTitle("CIRCLE DRAWER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
	}

	public class Mypanel extends JPanel {
		private static final long serialVersionUID = -8446012633908417142L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(x, y, diameter, diameter);
		}
	}

	public static void main(String[] args) {
		new Task7();

	}

}
