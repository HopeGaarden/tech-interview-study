package weatherStationGeneric;

public interface Observer<T> {
	void update(T data);
}
