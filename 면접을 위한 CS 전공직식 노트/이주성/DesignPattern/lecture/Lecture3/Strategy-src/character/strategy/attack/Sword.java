package character.strategy.attack;

import character.strategy.attack.AttackStrategy;

public class Sword implements AttackStrategy {

	@Override
	public void attack() {
		System.out.println("is attacking with Sword");
	}
}
