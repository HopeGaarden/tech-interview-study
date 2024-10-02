package hw8.state;

// MatterState<T>의 하위 타입인 T 제네릭
public class GasState<T extends MatterState<T>> implements State<T> {
    private T t;

    @Override
    public void set(T t) {
        this.t = t;
    }

    @Override
    public void setTemperature(double temperature) {
        // 기체 -> 액체화 확인
        if (t.getBoilingPoint().isPresent()) {
            // 현재 온도가 끓는 점보다 낮다면 액체화
            if (temperature < t.getBoilingPoint().get()) {
                System.out.println("Gas is condensing.");
                // 액체 상태로 변경
                t.setState(t.getLiquidState());
                System.out.println(t.getName() + " state changed: " + t.getState());
            }
        }
    }

    @Override
    public String toString() {
        return "gas";
    }
}
