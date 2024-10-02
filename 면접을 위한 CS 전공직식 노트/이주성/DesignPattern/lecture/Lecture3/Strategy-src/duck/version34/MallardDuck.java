package duck.version34;

public class MallardDuck extends Duck implements Flyable, Quackable {

	@Override
	public void display() {
		System.out.println("Mallard Duck\n");
	}

	@Override
	public void quack() {
		System.out.println("quack\n");		
	}

}
