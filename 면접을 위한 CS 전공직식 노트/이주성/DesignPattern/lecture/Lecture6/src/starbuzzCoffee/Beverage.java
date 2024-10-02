package src.starbuzzCoffee;

public abstract class Beverage {
	String description = "Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost(); // different types of beverage will have different cost
}
