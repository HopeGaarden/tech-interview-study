package duck.version34;

public class Duck {
	private Flyable flyBehavior;
	private Quackable quackBehavior;
	
	public void display() {
		System.out.println("Duck\n");
	}
	
	public void swim() {
		System.out.println("swim\n");
	}

	public Flyable getFlyBehavior() {
		return flyBehavior;
	}

	public void setFlyBehavior(Flyable flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public Quackable getQuackBehavior() {
		return quackBehavior;
	}

	public void setQuackBehavior(Quackable quackBehavior) {
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
