package swingObserver;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverFrame extends JFrame {
	public SwingObserverFrame(String name) {
		super(name);

		JButton button = new JButton("Are you sure?");

		button.addActionListener(event -> System.out.println("I wonder whether to do it or not~"));
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());

		this.getContentPane().add(BorderLayout.CENTER, button);
		this.setSize(200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
