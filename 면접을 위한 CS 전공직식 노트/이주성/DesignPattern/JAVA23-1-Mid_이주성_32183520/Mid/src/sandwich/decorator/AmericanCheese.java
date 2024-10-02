package sandwich.decorator;

import sandwich.Ingredient;

public class AmericanCheese extends SandwichIngredient {

    private String name = "American Cheese";
    public AmericanCheese(Ingredient ingredient) {
        super(ingredient);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "," + name;
    }

    @Override
    public int cost() {
        return super.cost() + 1000;
    }
}
