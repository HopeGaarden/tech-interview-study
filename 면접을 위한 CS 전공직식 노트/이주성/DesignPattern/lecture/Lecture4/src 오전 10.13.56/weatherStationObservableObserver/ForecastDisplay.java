package weatherStationObservableObserver;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
	private Observable weatherData;
	
	public ForecastDisplay(Observable weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this); // register forecast display
	}

	@Override
	public void update(Observable o, Object arg) {
		display();
	}

	@Override
	public void display() {
		System.out.println("forecast..");
	}


}
