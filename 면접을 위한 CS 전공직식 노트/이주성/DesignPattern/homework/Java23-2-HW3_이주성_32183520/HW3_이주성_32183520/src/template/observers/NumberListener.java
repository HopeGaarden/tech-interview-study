package template.observers;

import template.periodic.PeriodicElement;

import java.util.Arrays;

public class NumberListener implements PeriodicTableListener {
    int[] numbers;

    public NumberListener(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void update(PeriodicElement element) {
        // 등록한 원소 배열에 포함되는지 확인
        boolean isContain = Arrays.stream(numbers)
                .anyMatch(n -> n == element.getNumber());

        // 포함되면 update
        if (isContain) {
            notification(element);
        }
    }

    private void notification(PeriodicElement element) {
        System.out.println("[NumberListener] Notification: " + element.getName());
    }
}