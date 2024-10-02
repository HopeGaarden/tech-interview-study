package duck.v5;

import duck.v5.duck.*;
import duck.v5.flyBehavior.RocketPoweredFly;

public class MainTest {

	public MainTest() {
		System.out.println("src.duck.version5...");

		System.out.println("======MallardDuck=======");
		Duck duck1 = new MallardDuck();
		duck1.display();
		duck1.performQuack();
		duck1.performFly();
		System.out.println();

		System.out.println("======RubberDuck=======");
		Duck duck2 = new RubberDuck();
		duck2.display();
		duck2.performQuack();
		duck2.performFly();
		duck2.setFlyBehavior(new RocketPoweredFly());
		duck2.performFly();
		System.out.println();

		System.out.println("======DecoyDuck=======");
		Duck duck3 = new DecoyDuck();
		duck3.display();
		duck3.performQuack();
		duck3.performFly();
		System.out.println();

		System.out.println("======RedheadDuck=======");
		Duck duck4 = new RedheadDuck();
		duck4.display();
		duck4.performQuack();
		duck4.performFly();
	}

}
