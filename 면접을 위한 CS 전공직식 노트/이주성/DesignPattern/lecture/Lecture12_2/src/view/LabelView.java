package view;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Person;
import model.PersonList;

public class LabelView extends JFrame {
	PersonList model = null;
	JPanel panel = new JPanel();

	public LabelView(PersonList model) {
		super("LabelViewFrame");
		this.model = model;
		for (Person person : model) {
			panel.add(new JLabel(person.toString()));			
		}
		this.add(panel);
		this.setSize(300, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void display() {
		System.out.println("LabelViewFrame");
		this.setVisible(true);
	}
}
