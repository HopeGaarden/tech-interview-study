package src.starbuzzCoffee.decorator;

import src.starbuzzCoffee.Beverage;
import src.starbuzzCoffee.decorator.CondimentDecorator;

public class Milk extends CondimentDecorator {
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return this.beverage.getDescription() + " Milk";
	}

	@Override
	public double cost() {
		return this.beverage.cost() + .15;
	}

}
