package weatherStation;

public class MainTest {
	public MainTest() {
		WeatherData weatherData = new WeatherData(); // Subject

		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData); // Observer1
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData); // Observer2
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData); // Observer3

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}