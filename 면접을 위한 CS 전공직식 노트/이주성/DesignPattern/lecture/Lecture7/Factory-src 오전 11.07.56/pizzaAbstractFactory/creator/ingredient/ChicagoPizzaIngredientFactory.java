package pizzaAbstractFactory.creator.ingredient;

import pizzaAbstractFactory.creator.ingredient.Dough.Dough;
import pizzaAbstractFactory.creator.ingredient.Dough.ThickCrustDough;
import pizzaAbstractFactory.creator.ingredient.Pepperoni.Pepperoni;
import pizzaAbstractFactory.creator.ingredient.Pepperoni.SlicedPepperoni;
import pizzaAbstractFactory.creator.ingredient.cheese.Cheese;
import pizzaAbstractFactory.creator.ingredient.cheese.MozzarellaCheese;
import pizzaAbstractFactory.creator.ingredient.clarms.Clams;
import pizzaAbstractFactory.creator.ingredient.clarms.FrozenClams;
import pizzaAbstractFactory.creator.ingredient.sauce.PlumTomatoSauce;
import pizzaAbstractFactory.creator.ingredient.sauce.Sauce;
import pizzaAbstractFactory.creator.ingredient.veggies.BlackOlives;
import pizzaAbstractFactory.creator.ingredient.veggies.Eggplant;
import pizzaAbstractFactory.creator.ingredient.veggies.Spinach;
import pizzaAbstractFactory.creator.ingredient.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies[] veggies = {new BlackOlives(), new Spinach(), new Eggplant()};
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FrozenClams();
	}

}
