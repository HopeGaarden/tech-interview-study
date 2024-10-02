package weatherStationObservableObserver;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private Observable weatherData;
	
	
	public CurrentConditionsDisplay(Observable weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this); // register current condition display
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof WeatherData) {
			this.temperature = ((WeatherData)weatherData).getTemperature();
			this.humidity = ((WeatherData)weatherData).getHumidity();
			display();		
		}
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
}
