package template.observers;

import template.periodic.PeriodicElement;

public class PhaseListener implements PeriodicTableListener {
    String input;

    public PhaseListener(String input) {
        this.input = input;
    }

    @Override
    public void update(PeriodicElement element) {
        if (input.equals(element.getPhase())) {
            notification(element);
        }
    }

    private void notification(PeriodicElement element) {
        System.out.println("[PhaseListener] Notification: " + element.getName());
    }
}
