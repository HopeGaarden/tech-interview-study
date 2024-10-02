package swingObserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AngelListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("안돼. 분명 나중에 후회할거야");
		System.out.println("no. I'm sure you'll regret it later.");
	}
}
