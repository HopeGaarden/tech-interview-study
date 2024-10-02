package template.finder;

import template.PeriodicElement;
import template.UserInput;
import template.display.IPeriodicElementDisplay;
import template.display.PeriodicElementDisplay;

import java.util.List;

public class NumberFinder implements IPeriodicElementFinder {
    @Override
    public void find(List<PeriodicElement> periodicElements){

        System.out.println("\n... Start searching by number ...");
        System.out.print("Please enter [number] of PeriodicElement: ");

        // 입력 값 제한 (1~118 사이의 값만 검색 가능)
        int input = UserInput.getIntegerBetween(1, 118);

        for (PeriodicElement pe : periodicElements) {
            if (pe.getNumber() == input) {
                IPeriodicElementDisplay ped = new PeriodicElementDisplay();

                ped.display(pe);

                break;
            }
        }
    }
}
