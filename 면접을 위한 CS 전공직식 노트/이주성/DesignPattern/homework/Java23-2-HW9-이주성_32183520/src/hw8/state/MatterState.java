package hw8.state;

import java.util.Optional;

public interface MatterState<T> {
    // 이름 반환
    String getName();

    // 각각의 상태에 대한 State를 반환
    State<T> getArtificialState();
    State<T> getGasState();
    State<T> getLiquidState();
    State<T> getSolidState();
    State<T> getState();

    // 현재 상태 설정
    void setState(State<T> state);

    // 녹는 점 값 getter & setter
    Optional<Double> getMeltingPoint();
    void setMeltingPoint(Optional<Double> meltingPoint);

    // 끓는 점 값 getter & setter
    Optional<Double> getBoilingPoint();
    void setBoilingPoint(Optional<Double> boilingPoint);

    // 현재 상태의 물질의 온도 설정
    void setTemperature(double temperature);
}
