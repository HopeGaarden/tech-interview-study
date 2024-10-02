package template.subject;

import template.periodic.PeriodicElement;
import template.observers.PeriodicTableListener;

public interface Subject {
    void addListener(PeriodicTableListener listener);
    void removeListener(PeriodicTableListener listener);
    void notifyListeners(PeriodicElement element);
}
