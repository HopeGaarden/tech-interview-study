package weatherStationGeneric;



public class CurrentConditionsDisplay<T> implements Observer<T>, DisplayElement {

	private T data;

	@Override
	public void update(T data) {
		this.data = data;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + data);
	}
}
