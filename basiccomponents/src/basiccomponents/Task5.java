package basiccomponents;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task5 extends JFrame {
	private static final long serialVersionUID = -5922135556980128778L;
	private JPanel panel = new JPanel();
	private JSlider slider1 = new JSlider(0, 255);
	private JSlider slider2 = new JSlider(0, 255);
	private JSlider slider3 = new JSlider(0, 255);
	private JLabel redLabel = new JLabel("Red");
	private JLabel greenLabel = new JLabel("Green");
	private JLabel blueLabel = new JLabel("Blue");

	public Task5() {

		add(panel);
		panel.add(redLabel);
		panel.add(slider1);
		panel.add(greenLabel);
		panel.add(slider2);
		panel.add(blueLabel);
		panel.add(slider3);

		slider1.setValue(0);
		slider2.setValue(0);
		slider3.setValue(0);

		slider1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {

				panel.setBackground(new Color(255 - slider1.getValue(),
						255 - slider2.getValue(), 255 - slider3.getValue()));
			}

		});

		slider2.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {

				panel.setBackground(new Color(255 - slider1.getValue(),
						255 - slider2.getValue(), 255 - slider3.getValue()));
			}

		});
		slider3.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {

				panel.setBackground(new Color(255 - slider1.getValue(),
						255 - slider2.getValue(), 255 - slider3.getValue()));
			}

		});

		panel.setLayout(new GridLayout(3, 0));
		setTitle("RGB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Task5();
	}

}
