package pizzaFactoryMethod.creator;

import pizzaFactoryMethod.product.Pizza;

public abstract class PizzaStore {
	public abstract Pizza createPizza(String type); // factory method
	
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("---- Making a " + pizza.getName() + " ----");
		prepareToBoxing(pizza);
		return pizza;
	}

	void prepareToBoxing(Pizza pizza) {
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
	}
}
