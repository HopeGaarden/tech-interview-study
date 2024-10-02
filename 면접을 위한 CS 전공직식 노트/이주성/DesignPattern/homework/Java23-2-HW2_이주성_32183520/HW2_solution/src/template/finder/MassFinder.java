package template.finder;

import template.PeriodicElement;
import template.UserInput;
import template.display.IPeriodicElementDisplay;
import template.display.PeriodicElementDisplay;

import java.util.List;

public class MassFinder implements IPeriodicElementFinder {
    @Override
    public void find(List<PeriodicElement> periodicElements) {
        System.out.println("\n... Start searching by mass ...");
        System.out.print("Please enter [mass] of PeriodicElement: ");

        double mass = UserInput.getDouble();
        boolean flag = false;

        for (PeriodicElement pe : periodicElements) {
            if (Math.abs(pe.getMass() - mass) < 0.1) { // 오차범위 0.1 적용
                IPeriodicElementDisplay ped = new PeriodicElementDisplay();

                ped.display(pe);
                flag = true;

                break;
            }
        }
        if (!flag) System.out.println("not found");


    }
}
