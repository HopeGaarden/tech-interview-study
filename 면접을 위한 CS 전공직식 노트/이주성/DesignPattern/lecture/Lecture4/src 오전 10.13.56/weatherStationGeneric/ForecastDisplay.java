package weatherStationGeneric;

// ForecastDisplay 클래스 (generic)
class ForecastDisplay<T> implements Observer<T>, DisplayElement {
	private T weatherData;

	@Override
	public void update(T data) {
		display();
	}

	@Override
	public void display() {
		System.out.print("Forecast: ");
	}
}