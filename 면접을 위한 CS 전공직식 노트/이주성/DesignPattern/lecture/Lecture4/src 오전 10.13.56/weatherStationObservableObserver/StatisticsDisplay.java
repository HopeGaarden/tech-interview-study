package weatherStationObservableObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float minTemperature = 999;
	private float maxTemperature = -999;
	private float avgTemperature = 0;
	private List<Float> tempList = new ArrayList<>();
	private Observable weatherData;

	public StatisticsDisplay(Observable weatherData) {
		this.weatherData = weatherData;
		this.weatherData.addObserver(this); // register statistics display
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof WeatherData) {
			tempList.add(((WeatherData)weatherData).getTemperature());
			display();
		}
	}
	
	@Override
	public void display() {
		float sumTemperature = 0;
		for (float t : tempList) {
			if (t < minTemperature) minTemperature = t;
			if (t > maxTemperature) maxTemperature = t;
			sumTemperature += t;
		}
		avgTemperature = sumTemperature/(int)tempList.size();
		System.out.println("minTemperature=" + minTemperature + " maxTemperature=" + maxTemperature + " avgTemperature=" + avgTemperature);
	}
}
