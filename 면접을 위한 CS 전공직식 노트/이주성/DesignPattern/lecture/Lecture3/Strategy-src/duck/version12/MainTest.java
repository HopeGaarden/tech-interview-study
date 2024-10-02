package duck.version12;

public class MainTest {

	public MainTest() {
		System.out.println("src.duck.version1 & 2...");
		
		Duck[] ducks = { new MallardDuck(), new DecoyDuck(), new RedheadDuck(), new RubberDuck()};
		for (Duck duck: ducks) {
			duck.display();
			duck.quack();
			duck.swim();
			duck.fly();
		}
	}

}
