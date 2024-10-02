package character;

import character.strategy.attack.AttackStrategy;
import character.strategy.move.MoveStrategy;

public class Character {
	private String name;
    private MoveStrategy moveBehavior;
    private AttackStrategy attackBehavior;
    

	public Character(String name, MoveStrategy moveBehavior, AttackStrategy attackBehavior) {
		this.name = name;
		this.moveBehavior = moveBehavior;
		this.attackBehavior = attackBehavior;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoveBehavior(MoveStrategy moveBehavior) {
		this.moveBehavior = moveBehavior;
	}
    
	public void setAttackBehavior(AttackStrategy attackBehavior) {
		this.attackBehavior = attackBehavior;
	}
    
    public void move() {
    	moveBehavior.move();
    }
    
    public void attack() {
    	attackBehavior.attack();
    }

	@Override
	public String toString() {
		return "Character [name=" + name + ", moveBehavior=" + moveBehavior.getClass().getName() + ", attackBehavior=" + attackBehavior.getClass().getName()
				+ "]";
	}


}
