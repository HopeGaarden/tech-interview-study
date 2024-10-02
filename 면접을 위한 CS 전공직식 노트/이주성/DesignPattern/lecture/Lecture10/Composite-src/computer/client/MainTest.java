package computer.client;

import computer.composite.Computer;
import computer.leaf.Body;
import computer.leaf.Keyboard;
import computer.leaf.Monitor;
import computer.leaf.Mouse;

public class MainTest {

	public MainTest() {
		Body body = new Body(100, 70);
		Monitor monitor = new Monitor(20, 30);
		Keyboard keyboard = new Keyboard(5, 2);
		Mouse mouse = new Mouse(4, 1);

		Computer computer = new Computer();
		computer.addComponent(body);
		computer.addComponent(monitor);
		computer.addComponent(keyboard);
		computer.addComponent(mouse);
		
		System.out.println("Computer price: " + computer.getPrice());
		System.out.println("Computer power: " + computer.getPower());
	}

}
