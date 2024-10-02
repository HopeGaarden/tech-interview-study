package pizzaAbstractFactory;

import pizzaAbstractFactory.creator.store.ChicagoPizzaStore;
import pizzaAbstractFactory.creator.store.NYPizzaStore;
import pizzaAbstractFactory.creator.store.PizzaStore;
import pizzaAbstractFactory.provider.pizza.Pizza;

public class PizzaMainTest {

	public PizzaMainTest() {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();

		String[] types = {"cheese", "clam", "pepperoni", "veggie"};
		Pizza pizza = null;
		for (String type : types) {
			pizza = nyStore.orderPizza(type);
			System.out.println("Ethan ordered a " + pizza + "\n\n");
			
			pizza = chicagoStore.orderPizza(type);
			System.out.println("Joel ordered a " + pizza + "\n\n");
		}
	}

}
