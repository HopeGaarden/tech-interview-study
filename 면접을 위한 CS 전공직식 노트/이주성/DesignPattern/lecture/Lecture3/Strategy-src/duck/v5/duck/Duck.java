package duck.v5.duck;

import duck.v5.flyBehavior.FlyBehavior;
import duck.v5.quackBehavior.QuackBehavior;

public class Duck {
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;
	
	public void display() {
		System.out.println("Duck\n");
	}
	
	public void swim() {
		System.out.println("swim\n");
	}

	public FlyBehavior getFlyBehavior() {
		return flyBehavior;
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public QuackBehavior getQuackBehavior() {
		return quackBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public void performQuack() {
		if (quackBehavior != null) {
			quackBehavior.quack();
		}
	}
	
	public void performFly() {
		if (flyBehavior != null) {
			flyBehavior.fly();
		}
	}
}
