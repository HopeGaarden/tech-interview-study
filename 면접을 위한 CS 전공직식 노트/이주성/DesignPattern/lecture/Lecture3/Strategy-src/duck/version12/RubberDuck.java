package duck.version12;

public class RubberDuck extends Duck {
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
