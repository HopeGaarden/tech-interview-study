package weatherStationGeneric;

public class MainTest {
    public MainTest() {
        // Integer 타입의 데이터를 다루는 예제
        WeatherData<Integer> weatherData = new WeatherData<>();

        CurrentConditionsDisplay<Integer> currentDisplay = new CurrentConditionsDisplay<>();
        StatisticsDisplay<Integer> statisticsDisplay = new StatisticsDisplay<>();
        ForecastDisplay<Integer> forecastDisplay = new ForecastDisplay<>();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        // 날씨 데이터 업데이트
        weatherData.setData(80);
        weatherData.setData(75);
        weatherData.setData(85);
    }
}
