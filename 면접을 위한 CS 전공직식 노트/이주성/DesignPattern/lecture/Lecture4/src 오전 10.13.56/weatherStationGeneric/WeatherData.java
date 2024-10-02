package weatherStationGeneric;

import java.util.ArrayList;

public class WeatherData<T> implements Subject<T> {
    private ArrayList<Observer<T>> observers;
    private T data;

    public WeatherData() {
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer<T> o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer<T> o) {
        int index = observers.indexOf(o);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer<T> o : observers) {
            o.update(data);
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        notifyObservers();
    }
}
