package ramen.v3.ramen;

import ramen.v3.recipe.GeneralRamenRecipe;
import ramen.v3.recipe.Recipe;

public class Ramen {
	Recipe recipe = null;

	public Ramen() {
		this(new GeneralRamenRecipe());
	}
	
	public Ramen(Recipe recipe) {
		this.recipe = recipe;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	public void performCook() {
		recipe.cook();
	}
	
}
