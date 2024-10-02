package character.strategy.move;

public class Jump implements MoveStrategy {

	@Override
	public void move() {
		System.out.println("is moving by jumping");
	}
}
