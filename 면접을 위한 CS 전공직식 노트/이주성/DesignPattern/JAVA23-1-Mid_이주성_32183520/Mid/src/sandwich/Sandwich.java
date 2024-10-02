package sandwich;

import sandwich.recipe.Recipe;

public class Sandwich implements Ingredient {
    // Recipe의 참조변수를 가지고 있음
    private Recipe recipe;
    public Sandwich(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String getDescription() {
        // 구체적인 레시피 결정
        return this.recipe.cook() + "Sandwich";
    }

    @Override
    public int cost() {
        return 0;
    }
}
