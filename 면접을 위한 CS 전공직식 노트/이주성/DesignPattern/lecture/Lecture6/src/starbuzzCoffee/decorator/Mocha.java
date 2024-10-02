package src.starbuzzCoffee.decorator;

import src.starbuzzCoffee.Beverage;
import src.starbuzzCoffee.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return this.beverage.getDescription() + " Mocha";
	}

	@Override
	public double cost() {
		return this.beverage.cost() + .20;
	}

}
