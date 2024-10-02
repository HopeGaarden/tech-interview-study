package controller;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Person;
import view.PersonDialog;
import view.ImageView;
import view.TextView;

public class PersonListController extends JFrame implements ListSelectionListener, MouseListener {
	private List<Person> pList;
	private ImageView imageView;
	private TextView textView;	

	private JPanel panel = new JPanel();
	private DefaultListModel<String> listmodel = new DefaultListModel<>();
	private JList<String> list = new JList<>(listmodel);
	private Person emptyPerson = new Person(0, "");
	
	public PersonListController(List<Person> pList, ImageView imageView, TextView textView) {
		super("PersonController");
		// model 
		this.pList = pList;
		// views
		this.imageView = imageView;
		this.textView = textView;

		// JList
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // single selection
		list.addListSelectionListener(this);
		list.addMouseListener(this);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		panel.add(list);
		this.add(panel);

		// JMenu
		JMenuBar menuBar = new JMenuBar();
		// Person Menu, P - Mnemonic
		JMenu personMenu = new JMenu("Person");
		personMenu.setMnemonic(KeyEvent.VK_P);
		menuBar.add(personMenu);
		// Person->Add, A - Mnemonic
		JMenuItem addMenuItem = new JMenuItem("Add", KeyEvent.VK_A);
		personMenu.add(addMenuItem);
		this.setJMenuBar(menuBar);
		addMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent event) {
				PersonDialog personDialog = new PersonDialog();
				personDialog.setVisible(true);
				System.out.println("getReturnValue=" + personDialog.getReturnValue());
				if (personDialog.getReturnValue() == PersonDialog.OK) {
					Person person = personDialog.getPerson();
					System.out.println("PersonTableFrame: add " + person);
					add(person);
				}
			}	
		});
		
		this.setSize(200, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Person get(int index) {
		return this.pList.get(index);
	}

	public void add(Person person) {
		int index = this.pList.size();
		this.listmodel.add(index, person.getName());
		this.pList.add(person);
	}
	
	public void edit(int index, Person other) {
		this.pList.set(index, other);
		this.listmodel.remove(index);
		this.listmodel.add(index, other.getName());
		ListSelectionModel selmodel = this.list.getSelectionModel();
        selmodel.setLeadSelectionIndex(index);
	}
	
	public void remove(int index) {
		this.pList.remove(index);
		this.listmodel.remove(index);
		this.pList.forEach(System.out::println);
		updateView(emptyPerson);
	}
	
	public void updateView(Person person) {
		if (person == null) return;
		
		ImageIcon icon = new ImageIcon(new ImageIcon("./" + person.getName().toLowerCase() + ".png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		this.imageView.display(icon);
		String text = "<html><h1>Person <br/> Age:" + person.getAge() + "<br/> Name:" + person.getName() + "</h1></html>";
		this.textView.display(text);
	}
	
	/*
	public static void main(String[] args) {
		// create a model
		List<Person> pList = new ArrayList<>();

		// create views
		ImageView imageView = new ImageView();
		TextView textView = new TextView();
		
		// create a controller
		PersonListController controller = new PersonListController(pList, imageView, textView);

		Person[] people = {
				new Person(3000, "Dooly"),
				new Person(30, "Ddochi"),
				new Person(25, "kildong"),
				new Person(20000, "Douner"),
				new Person(3, "HeeDong")
		};
		for (Person person : people) {
			controller.add(person);
		}
	}
	*/
	
	// if a list item is selected, update the view
	@Override
	public void valueChanged(ListSelectionEvent e) {
        int index = this.list.getSelectedIndex();
        System.out.println("valueChanged index=" + index);
        if (index != -1) { 
        	updateView(this.pList.get(index));
        }
	}

	// if a list item is double clicked, remove the item
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int index = list.locationToIndex(e.getPoint());
			remove(index);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
