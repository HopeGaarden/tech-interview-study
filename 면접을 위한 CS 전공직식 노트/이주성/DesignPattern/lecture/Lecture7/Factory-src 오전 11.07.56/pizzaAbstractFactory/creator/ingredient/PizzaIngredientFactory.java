package pizzaAbstractFactory.creator.ingredient;

import pizzaAbstractFactory.creator.ingredient.Dough.Dough;
import pizzaAbstractFactory.creator.ingredient.Pepperoni.Pepperoni;
import pizzaAbstractFactory.creator.ingredient.cheese.Cheese;
import pizzaAbstractFactory.creator.ingredient.clarms.Clams;
import pizzaAbstractFactory.creator.ingredient.sauce.Sauce;
import pizzaAbstractFactory.creator.ingredient.veggies.Veggies;

public interface PizzaIngredientFactory {
	Dough createDough();
	Sauce createSauce();
	Cheese createCheese();
	Veggies[] createVeggies();
	Pepperoni createPepperoni();
	Clams createClam();
}
