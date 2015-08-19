package basiccomponents;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Task6 extends JFrame{
	private static final long serialVersionUID = 5450587245490274011L;
	private JLabel label1 = new JLabel("Enter time in seconds: ");
	private JTextField field = new JTextField ();
	private JButton click = new JButton("START COUNTDOWN");
	private JLabel label2 = new JLabel("");
	private Timer t = new Timer(1000, new Action());
	int time = 0;
	
	public Task6 () {
		setLayout(new GridLayout(4,0));
		add(label1);
		add(field);
		add(click);
		add(label2);
		
		click.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				time = Integer.parseInt(field.getText());
				t.start();
			}
			
		});
		
		setTitle("COUNTDOWN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setVisible(true);
	}
	
	private class Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(time > 0){
				time = time - 1;
				label2.setText(Integer.toString(time));
			}
		}
	}

	public static void main(String[] args) {
		new Task6();

	}

}
