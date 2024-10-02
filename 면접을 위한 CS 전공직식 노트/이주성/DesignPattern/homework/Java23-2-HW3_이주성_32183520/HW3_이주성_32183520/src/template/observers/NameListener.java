package template.observers;

import template.periodic.PeriodicElement;

import java.util.Arrays;

public class NameListener implements PeriodicTableListener{
    String[] inputs;

    public NameListener(String[] inputs) {
        this.inputs = inputs;
    }

    @Override
    public void update(PeriodicElement element) {
        // 소문자, 대분자 구분없이 탐지
        boolean isContain = Arrays.stream(inputs)
                .anyMatch(s ->
                        s.toLowerCase().equals(element.getName().toLowerCase()));
        if (isContain) {
            notification(element);
        }
    }

    private void notification(PeriodicElement element) {
        System.out.println("[NameListener] Notification: " + element.getName());
    }
}
