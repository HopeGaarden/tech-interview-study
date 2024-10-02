package duck.version34;

public class RubberDuck extends Duck implements Flyable, Quackable {
	@Override
	public void display() {
		System.out.println("Rubber Duck\n");
	}
	
	@Override
	public void quack() {
		System.out.println("squeak\n");		
	}

	@Override
	public void fly() {
		System.out.println("cannot fly\n");
	}
}
