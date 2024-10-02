package duck.version34;

public class DecoyDuck extends Duck implements Flyable, Quackable {
	@Override
	public void display() {
		System.out.println("Decoy Duck\n");
	}
	
	@Override
	public void quack() {
		System.out.println("quack\n");		
	}
}
