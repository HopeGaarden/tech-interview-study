package template.observers;

import template.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.List;

public class GroupListener implements PeriodicTableListener {
    private int group;
    private List<PeriodicElement> peList;

    public GroupListener(int group) {
        this.group = group;
        peList = new ArrayList<>();
    }

    @Override
    public void update(PeriodicElement element) {
        // null인 경우
        if (group == 0) {
            if (element.getGroup() > 18 || element.getGroup() < 1) {
                peList.add(element);
                notification(element);
            }
        }

        if (element.getGroup() == group) {
            peList.add(element);
            notification(element);
        }
    }

    private void notification(PeriodicElement element) {
        System.out.println("[GroupListener] Notification: " + element.getName());
    }
}
