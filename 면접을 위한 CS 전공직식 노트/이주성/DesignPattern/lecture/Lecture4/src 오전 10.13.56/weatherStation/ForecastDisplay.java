package weatherStation;

public class ForecastDisplay implements Observer, DisplayElement {

	public ForecastDisplay(Subject weatherData) {
		weatherData.registerObserver(this); // register forecast display
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		display();
	}

	@Override
	public void display() {
		System.out.println("forecast..");
	}


}
