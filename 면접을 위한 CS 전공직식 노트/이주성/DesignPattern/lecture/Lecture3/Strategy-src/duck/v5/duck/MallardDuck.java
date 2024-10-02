package duck.v5.duck;

import duck.v5.flyBehavior.FlyWithWings;
import duck.v5.quackBehavior.Quack;

public class MallardDuck extends Duck {
	public MallardDuck() {
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}

	@Override
	public void display() {
		System.out.println("Mallard Duck\n");
	}
}
