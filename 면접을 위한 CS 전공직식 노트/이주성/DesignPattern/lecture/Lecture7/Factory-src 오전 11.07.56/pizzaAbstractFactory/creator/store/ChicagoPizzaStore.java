package pizzaAbstractFactory.creator.store;

import pizzaAbstractFactory.creator.ingredient.ChicagoPizzaIngredientFactory;
import pizzaAbstractFactory.creator.ingredient.PizzaIngredientFactory;
import pizzaAbstractFactory.provider.pizza.*;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

		if (type.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("chicago Cheese Pizza ");
		}
		else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Pepperoni Pizza");
		}
		else if (type.equals("clam")) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Clam Pizza");
		}
		else if (type.equals("veggie")) {
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Veggie Pizza");
		}
		return pizza;
	}

}
