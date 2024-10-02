package template.subject;

import template.periodic.PeriodicElement;
import template.observers.PeriodicTableListener;

import java.util.ArrayList;
import java.util.List;

public class PeriodicTable implements Subject {
    private List<PeriodicTableListener> listeners;
    private List<PeriodicElement> elements;

    // 생성자
    public PeriodicTable() {
        listeners = new ArrayList<>();
        elements = new ArrayList<>();
    }

    // 원소 추가
    public void addElement(PeriodicElement element) {
        elements.add(element);
        notifyListeners(element); // 리스너들에게 업데이트 알림
    }

    @Override
    public void addListener(PeriodicTableListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(PeriodicTableListener listener) {
        int i = this.listeners.indexOf(listener);
        if (i >= 0) {
            this.listeners.remove(i);
        }
    }

    @Override
    public void notifyListeners(PeriodicElement element) {
        for (PeriodicTableListener listener : this.listeners) {
            listener.update(element);
        }
    }
}