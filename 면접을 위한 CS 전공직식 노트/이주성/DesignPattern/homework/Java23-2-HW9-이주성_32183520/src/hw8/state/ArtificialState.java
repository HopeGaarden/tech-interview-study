package hw8.state;

// MatterState<T>의 하위 타입인 T 제네릭
public class ArtificialState<T extends MatterState<T>> implements State<T> {
    private T t;

    @Override
    public void set(T t) {
        this.t = t;
    }

    @Override
    public void setTemperature(double temperature) {
        // Artificial set Temperature
    }

    @Override
    public String toString() {
        return "artificial";
    }
}
