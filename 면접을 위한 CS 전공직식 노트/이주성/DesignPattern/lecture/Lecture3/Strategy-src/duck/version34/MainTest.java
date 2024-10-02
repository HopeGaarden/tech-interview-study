package duck.version34;

public class MainTest {

	public MainTest() {
		System.out.println("src.duck.version3 & 4...");
		
		Duck[] ducks = { new MallardDuck(), new DecoyDuck(), new RedheadDuck(), new RubberDuck()};
		for (Duck duck: ducks) {
			duck.display();
			((Quackable)duck).quack();
			duck.swim();
			((Flyable)duck).fly();
		}
	}

}
