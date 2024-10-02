package duck.v5.flyBehavior;

import duck.v5.flyBehavior.FlyBehavior;

public class RocketPoweredFly implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("RocketPoweredFly");
	}

}
