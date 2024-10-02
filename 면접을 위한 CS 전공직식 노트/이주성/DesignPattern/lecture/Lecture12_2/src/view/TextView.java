package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextView extends JFrame {
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	public TextView() {
		super("TextView");
		panel.add(label);		
		this.add(panel);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void display(String text) {
		System.out.println(text);
		label.setText(text);
		label.invalidate();
	}
}
