package guipaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PainPanel extends JPanel {
	private static final long serialVersionUID = 3976007952746528741L;

	private static PointArray points;
	private Color activeColor;
	private int activeSize;
	private boolean paint = true;
	private static final int maxSize = 20;
	private static final int minSize = 5;
	public static String s = "";
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	private static Color[] supportedColors = new Color[] { Color.RED,
			Color.BLUE, Color.GREEN, Color.ORANGE, Color.PINK };
	// public static int[] sizeArray = new int[] { 10, 15, 20, 30 };
	JButton increase = new JButton("+");
	JButton reduce = new JButton("-");
	JButton text = new JButton("text");
	JButton undo = new JButton("undo");
	JButton redo = new JButton("redo");

	public PainPanel(int height, int width) {

		super();
		activeSize = 5;
		points = new PointArray();
		setSize(height, width);
		setBackground(Color.WHITE);

		for (int i = 0; i < supportedColors.length; i++) {

			JButton color = new JButton("Pick");

			color.setName(Integer.toString(i));
			color.setForeground(supportedColors[i]);

			color.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton cliked = (JButton) e.getSource();

					String name = cliked.getName();
					int index = Integer.parseInt(name);
					activeColor = supportedColors[index];

				}

			});
			add(color);

		}
		addMouseMotionListener(new MouseHandler());

		increase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (activeSize < maxSize) {
					activeSize += 5;
				}
			}
		});

		reduce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (activeSize > minSize) {
					activeSize -= 5;
				}

			}

		});

		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}

		});
		
		redo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}

		});

		text.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s += JOptionPane.showInputDialog("Input X and Y: ");
				repaint();
			}

		});

		add(increase);
		add(reduce);
		add(text);
		add(undo);
		add(redo);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < points.getLength() -1 ; i++) {
			Point p = points.elementAt(i);
			Point p1 = points.elementAt(i + 1);
			g.setColor(p.getColor());
			if (paint) {
				g.drawLine(p.getX(), p.getY(), p1.getX(),  p1.getY());
			} else {
				g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
			}
			if (text.isSelected()) {
				g.drawString("Uneseni tekst", Integer.parseInt(s.substring(0, s.indexOf(' '))),
						Integer.parseInt(s.substring(s.indexOf(' ')+1)));
			}
		}
	}

	private class MouseHandler implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			Point newPoint = new Point(e.getX(), e.getY(), activeColor,
					activeSize);
			Point newPoint1 = new Point(x2, y2, e.getX(), e.getY(),
					activeColor, activeSize);

			x2 = e.getX();
			y2 = e.getY();

			points.addPoint(newPoint);

			if (e.isShiftDown() == true) {
				newPoint.setColor(Color.WHITE);
			}

			if (e.isControlDown() == true) {
				paint = false;
			} else {
				paint = true;
			}

			points.addPoint(newPoint);
			repaint();

		}

		public void mousePressed(MouseEvent e) {

			x1 = e.getX();
			y1 = e.getY();
			x2 = x1;
			y2 = y1;

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


	}
}
