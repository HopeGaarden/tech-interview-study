package sandwich.factory;

import sandwich.Ingredient;
import sandwich.decorator.Lettuce;
import sandwich.decorator.Onion;
import sandwich.decorator.Tomato;

public class OtherIngredientFactory {
    public static Ingredient getInstance(String name, Ingredient ingredient) {
        switch (name) {
            case "Lettuce":
                return new Lettuce(ingredient);
            case "Tomato":
                return new Tomato(ingredient);
            case "Onion":
                return new Onion(ingredient);
            default:
                return ingredient;
        }
    }
}
