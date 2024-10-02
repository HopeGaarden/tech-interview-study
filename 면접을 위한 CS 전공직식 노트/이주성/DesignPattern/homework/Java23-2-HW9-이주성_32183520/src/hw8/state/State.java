package hw8.state;

public interface State<T> {
    // 상태의 원소 설정
    void set(T element);

    // 상태의 온도 설정
    // 녹는점이나 끓는 점과 같은 온도 변화가 생길 경우 이 메서드 사용
    void setTemperature(double temperature);
}
