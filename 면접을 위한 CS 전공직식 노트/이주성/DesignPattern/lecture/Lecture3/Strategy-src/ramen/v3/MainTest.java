package ramen.v3;

import ramen.v3.ramen.Ramen;
import ramen.v3.recipe.*;

public class MainTest {

	public MainTest() {
		System.out.println("strategy - recipe by general, cheese, milk, withoutBroth, vinegar...");

		Recipe[] recipes = {
				new GeneralRamenRecipe(),
				new CheeseRamenRecipe(),
				new MilkRamenRecipe(),
				new RamenWithoutBrothRecipe(),
				new VinegarRamenRecipe()
		};

		Ramen ramen = new Ramen();
		for (var recipe : recipes) {
			ramen.setRecipe(recipe);
			ramen.performCook();
		}
	}

}
