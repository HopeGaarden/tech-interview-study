package template.observers;

import template.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.List;

public class PeriodListener implements PeriodicTableListener{
    private int period;
    private List<PeriodicElement> peList;

    public PeriodListener(int period) {
        this.period = period;
        peList = new ArrayList<>();
    }

    @Override
    public void update(PeriodicElement element) {
        if (element.getGroup() == period) {
            peList.add(element);
            notification(element);
        }
    }

    private void notification(PeriodicElement element) {
        System.out.println("[PeriodListener] Notification: " + element.getName());
    }
}
