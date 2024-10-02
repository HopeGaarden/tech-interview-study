package duck.v5.duck;

import duck.v5.flyBehavior.FlyWithWings;
import duck.v5.quackBehavior.Quack;

public class RedheadDuck extends Duck {
	public RedheadDuck() {
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}
	
	@Override
	public void display() {
		System.out.println("Redhead Duck\n");
	}
}
