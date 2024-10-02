package template.finder;

import template.PeriodicElement;
import template.UserInput;
import template.display.IPeriodicElementDisplay;
import template.display.PeriodicElementDisplay;

import java.util.ArrayList;
import java.util.List;

public class PeriodFinder implements IPeriodicElementFinder {
    @Override
    public void find(List<PeriodicElement> periodicElements){

        System.out.println("\n... Start searching by period ...");
        System.out.print("Please enter [period] of PeriodicElement: ");

        // 입력 값 제한 (1~7 사이의 값만 검색 가능)
        int input = UserInput.getIntegerBetween(1, 7);

        List<PeriodicElement> list = new ArrayList<>();

        for (PeriodicElement pe : periodicElements) {
            if (pe.getPeriod() == input) {
                list.add(pe);
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
