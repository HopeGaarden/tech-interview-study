package sandwich.observer;

import java.util.ArrayList;

public class SandwichOrderSubject implements Subject {
    // 관찰 대상인 Observer들의 리스트
    public ArrayList<Observer> observers;

    public SandwichOrderSubject() {
        observers = new ArrayList<>();
    }

    // 옵저버 추가
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    // 옵저버 삭제
    @Override
    public void removeObserver(Observer observer) {
        if (observers.indexOf(observer) >= 0) {
            observers.remove(observer);
        }
    }

    // 옵저버들에게 알림
    @Override
    public void notifyObservers(String orderDetails) {
        for (Observer o : observers) {
            o.update(orderDetails);
        }
    }
}
