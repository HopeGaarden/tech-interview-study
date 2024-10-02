package pizzaAbstractFactory.creator.ingredient;

import pizzaAbstractFactory.creator.ingredient.Dough.Dough;
import pizzaAbstractFactory.creator.ingredient.Dough.ThinCrustDough;
import pizzaAbstractFactory.creator.ingredient.Pepperoni.Pepperoni;
import pizzaAbstractFactory.creator.ingredient.Pepperoni.SlicedPepperoni;
import pizzaAbstractFactory.creator.ingredient.cheese.Cheese;
import pizzaAbstractFactory.creator.ingredient.cheese.ReggianoCheese;
import pizzaAbstractFactory.creator.ingredient.clarms.Clams;
import pizzaAbstractFactory.creator.ingredient.clarms.FreshClams;
import pizzaAbstractFactory.creator.ingredient.sauce.MarinaraSauce;
import pizzaAbstractFactory.creator.ingredient.sauce.Sauce;
import pizzaAbstractFactory.creator.ingredient.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies[] veggies = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}

}
