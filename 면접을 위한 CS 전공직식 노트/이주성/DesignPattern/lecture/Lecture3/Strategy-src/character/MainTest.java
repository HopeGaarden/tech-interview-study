package character;

import character.strategy.attack.Archer;
import character.strategy.attack.Ax;
import character.strategy.attack.Fireball;
import character.strategy.attack.Sword;
import character.strategy.move.Fly;
import character.strategy.move.Jump;
import character.strategy.move.Run;
import character.strategy.move.Walk;

public class MainTest {

	public MainTest() {
		System.out.println("strategy - src.character move/attack behavior by friendly, defensive...");

		Character[] characters = {
				new Character("Warrior", new Run(), new Sword()),
				new Character("Magician", new Fly(), new Fireball()),
				new Character("Archer", new Walk(), new Archer()),
				new Character("Monster", new Jump(), new Ax())
		};

		for (var character : characters) {
			System.out.println();
			System.out.println(character.getName());
			character.move();
			character.attack();
			System.out.println(character);
			System.out.println();
		}

        // Change the src.character's move behavior at runtime
		System.out.println("charater[0]..... ");
        characters[0].setMoveBehavior(new Walk());
        characters[0].move();
        characters[0].attack();
        System.out.println(characters[0]);
	}
}
