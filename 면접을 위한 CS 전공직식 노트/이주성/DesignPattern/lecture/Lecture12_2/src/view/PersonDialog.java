package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Person;

public class PersonDialog extends JDialog implements ActionListener, KeyListener {
	
	public final static int OK = 1;
	public final static int CANCEL = 2;
	int returnValue = 0;

	JLabel label1 = new JLabel("Age");
	JLabel label2 = new JLabel("Name");

	JTextField textfield1 = new JTextField(20);
	JTextField textfield2 = new JTextField(20);

	JButton button1 = new JButton("Submit");
		
	Person person = new Person();

	public PersonDialog() {
		setTitle("Person Dialog");
		setLayout(null); // no layout - absolute positioning
		
		label1.setBounds(20, 30, 100, 20);
		label2.setBounds(20, 60, 100, 20);
		this.add(label1);
		this.add(label2);
		
		textfield1.setBounds(120, 30, 150, 20);
		textfield2.setBounds(120, 60, 150, 20);
		this.add(textfield1);
		this.add(textfield2);
		textfield1.addKeyListener(this);
		
		button1.setBounds(60, 220, 160, 20);
		button1.addActionListener(this);
		this.add(button1);
		
		setSize(300, 300);
		setModal(true); // set Modal (dialog)
	}

	public void addPerson() {
		person.setAge(Integer.parseInt(textfield1.getText()));
		person.setName(textfield2.getText());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton)e.getSource() == button1) {
			addPerson();
			returnValue = OK;
			dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			Toolkit.getDefaultToolkit().beep();
			System.out.println("Enter pressed");

			addPerson();
			System.out.println("Person Dialog KeyPressed: " + person);
			returnValue = OK;
			dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public int getReturnValue()
	{
		return returnValue;
	}

	public Person getPerson()
	{
		return person;
	}

}
