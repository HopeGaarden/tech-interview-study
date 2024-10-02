package hw8.state;

// MatterState<T>의 하위 타입인 T 제네릭
public class LiquidState<T extends MatterState<T>> implements State<T> {
    private T t;

    @Override
    public void set(T t) {
        this.t = t;
    }

    @Override
    public void setTemperature(double temperature) {
        // 변경 플래그
        boolean changeState = false;

        // 액체 -> 고체화 확인
        if (t.getMeltingPoint().isPresent()) {
            // 현재 온도가 녹는 점보다 낮다면 고체화
            if (temperature < t.getMeltingPoint().get()) {
                System.out.println("Liquid is solidifying.");
                // 고체 상태로 변경
                t.setState(t.getSolidState());
                changeState = true;
            }
        }

        // 액체 -> 기체화 확인
        if (!changeState && t.getBoilingPoint().isPresent()) {
            // 현재 온도가 끓는 점보다 같거나 높으면 기체화
            if (temperature >= t.getBoilingPoint().get()) {
                System.out.println("Liquid is vaporizing.");
                // 기체 상태로 변경
                t.setState(t.getGasState());
                changeState = true;
            }
        }

        // 변화했으면 출력
        if (changeState) {
            System.out.println(t.getName() + " state changed: " + t.getState());
        }
    }

    @Override
    public String toString() {
        return "liq";
    }
}
