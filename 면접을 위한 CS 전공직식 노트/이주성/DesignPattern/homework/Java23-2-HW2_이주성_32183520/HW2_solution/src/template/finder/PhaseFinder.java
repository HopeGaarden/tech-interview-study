package template.finder;

import template.PeriodicElement;
import template.UserInput;
import template.display.IPeriodicElementDisplay;
import template.display.PeriodicElementDisplay;

import java.util.ArrayList;
import java.util.List;

public class PhaseFinder implements IPeriodicElementFinder {
    @Override
    public void find(List<PeriodicElement> periodicElements) {
        System.out.println("\n... Start searching by Phase ...");
        System.out.print("Please enter [Phase] of PeriodicElement: ");

        String input = UserInput.getString();

        List<PeriodicElement> list = new ArrayList<>();

        for (PeriodicElement pe : periodicElements) {
            if (pe.getPhase().equals(input)) {
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
