package character.strategy.move;

public class Fly implements MoveStrategy {

	@Override
	public void move() {
		System.out.println("is moving by flying");
	}
}
