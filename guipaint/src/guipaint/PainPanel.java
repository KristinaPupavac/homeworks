package guipaint;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PainPanel extends JPanel {
	private static final long serialVersionUID = 3976007952746528741L;

	private ColorPicker colorPicker;
	private static PointArray points;
	private int activeSize;
	private boolean paint = true;
	private static final int maxSize = 20;
	private static final int minSize = 5;
	public static String s = "";
	private PointArray redoPoints;
	private PointArray undoPoints;
	private boolean isUndo;

	JPanel panel1 = new JPanel();
	JButton increase = new JButton("+");
	JButton reduce = new JButton("-");
	JButton text = new JButton("text");
	JButton undo = new JButton("undo");
	JButton redo = new JButton("redo");

	public PainPanel(int height, int width) {

		super();
		colorPicker = new ColorPicker(width);
		activeSize = 5;
		this.setLayout(new BorderLayout());
		points = new PointArray();
		setSize(height, width);
		setBackground(Color.WHITE);

		add(colorPicker, BorderLayout.NORTH);
		add(panel1, BorderLayout.EAST);
		panel1.setLayout(new GridLayout(5, 0));
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
				PointArray undoPoints = new PointArray();
				redoPoints = new PointArray();
				for (int i = 0; i < points.getLength() - 5; i++) {
					undoPoints.addPoint(points.elementAt(i));
				}
				isUndo = true;
				points = undoPoints;
				repaint();
			}
		});

		redo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isUndo) {
					points.addPoint(redoPoints.elementAt(undoPoints.getLength() + 1));
				}
				repaint();
			}

		});

		text.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = getGraphics();
				s += JOptionPane.showInputDialog("Input X and Y: ");
				g.drawString("Uneseni tekst",
						Integer.parseInt(s.substring(0, s.indexOf(" "))),
						Integer.parseInt(s.substring(s.indexOf(" ") + 1)));
				repaint();
			}

		});

		panel1.add(increase);
		panel1.add(reduce);
		panel1.add(text);
		panel1.add(undo);
		panel1.add(redo);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < points.getLength() - 1; i++) {
			Point p = points.elementAt(i);
			Point p1 = points.elementAt(i + 1);
			g.setColor(p.getColor());
			g.setColor(p1.getColor());
			if (paint) {
				g2d.setStroke(new BasicStroke(p.getSize()));
				g.drawLine(p.getX(), p.getY(), p1.getX(), p1.getY());
			} else {
				g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
			}
		}
	}

	private class MouseHandler implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			Point newPoint = new Point(e.getX(), e.getY(),
					colorPicker.getActive(), activeSize);
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

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
