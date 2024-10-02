package weatherStationGeneric;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay<T> implements Observer<T>, DisplayElement {
    private float minTemperature = 999;
    private float maxTemperature = -999;
    private float avgTemperature = 0;
    private List<Float> tempList = new ArrayList<>();
    private T Data;

    @Override
    public void update(T data) {
        float value = Float.parseFloat(data.toString());

        tempList.add(value);
        display();
    }

    @Override
    public void display() {
        float sumTemperature = 0;

        for (float t : tempList) {
            if (t < minTemperature) minTemperature = t;
            if (t > maxTemperature) maxTemperature = t;
            sumTemperature += t;
        }

        avgTemperature = sumTemperature / (int) tempList.size();

        System.out.println("minTemperature=" + minTemperature + " maxTemperature=" + maxTemperature + " avgTemperature=" + avgTemperature);
    }
}
