package template.finder;

import template.PeriodicElement;
import template.UserInput;
import template.display.IPeriodicElementDisplay;
import template.display.PeriodicElementDisplay;

import java.util.ArrayList;
import java.util.List;

public class TypeFinder implements IPeriodicElementFinder {
    @Override
    public void find(List<PeriodicElement> periodicElements) {
        System.out.println("\n... Start searching by type ...");
        System.out.print("Please enter [type] of PeriodicElement: ");

        String input = UserInput.getStringNullalbe();

        List<PeriodicElement> list = new ArrayList<>();

        for (PeriodicElement pe : periodicElements) {
            if (pe.getType().equals(input)) {
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
