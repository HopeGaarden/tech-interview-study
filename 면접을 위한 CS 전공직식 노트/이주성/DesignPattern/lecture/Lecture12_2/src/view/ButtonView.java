package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Person;
import model.PersonList;

public class ButtonView extends JFrame {
	PersonList model = null;
	JPanel panel = new JPanel();

	public ButtonView(PersonList model) {
		super("ButtonViewFrame");
		this.model = model;
		
		for (Person person : model) {
			panel.add(new JButton(person.toString()));			
		}
		this.add(panel);
		this.setSize(300, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void display() {
		System.out.println("ButtonViewFrame");
		this.setVisible(true);
	}
}
