package duck.v5.duck;

import duck.v5.quackBehavior.Squeak;

public class RubberDuck extends Duck {
	public RubberDuck() {
		setQuackBehavior(new Squeak());
	}
	
	@Override
	public void display() {
		System.out.println("Rubber Duck\n");
	}
}
