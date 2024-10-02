package view;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageView extends JFrame {
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	public ImageView() {
		super("ImageView");
		panel.add(label);		
		this.add(panel);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void display(ImageIcon icon) {
		//System.out.println("img=" + person.getName().toLowerCase() + ".png");
		//ImageIcon icon = new ImageIcon(new ImageIcon("./" + person.getName().toLowerCase() + ".png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		label.setIcon(icon);
		label.invalidate();
		//panel.revalidate();
	}
}
