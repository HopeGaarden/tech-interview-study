package template.finder;

import template.PeriodicElement;
import template.UserInput;
import template.display.IPeriodicElementDisplay;
import template.display.PeriodicElementDisplay;

import java.util.ArrayList;
import java.util.List;

public class GroupFinder implements IPeriodicElementFinder {
    @Override
    public void find(List<PeriodicElement> periodicElements) {
        System.out.println("\n... Start searching by group ...");
        System.out.print("Please enter [group] of PeriodicElement: ");

        // 입력 값 제한 (1~18 사이의 값 또는 Null만 검색 가능)
        int input = UserInput.getNullOrIntegerBetween(1, 7);

        List<PeriodicElement> list = new ArrayList<>();

        // null인 경우
        if (input == 0) {
            for (PeriodicElement pe : periodicElements) {
                if (pe.getGroup() >= 1 && pe.getGroup() <= 18) {
                    continue;
                } else {
                    list.add(pe);
                }
            }
        } else {
            for (PeriodicElement pe : periodicElements) {
                if (pe.getGroup() == input) {
                    list.add(pe);
                }
            }
        }

        if (!list.isEmpty()) {
            IPeriodicElementDisplay ped = new PeriodicElementDisplay();
            ped.displayList(list);
        } else {
            System.out.println("not found");
        }
    }
}
