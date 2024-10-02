package template.display;

import template.PeriodicElement;

import java.util.List;

public class PeriodicElementDisplay implements IPeriodicElementDisplay {
    @Override
    public void display(PeriodicElement periodicElement) {
        if (periodicElement != null) {
            System.out.println(periodicElement);
            System.out.println("\n... End of Search ...\n");
        }
    }

    @Override
    public void displayList(List<PeriodicElement> periodicElementList) {
        for (PeriodicElement pe : periodicElementList) {
            System.out.print(pe.getName()+"\n");
        }
        System.out.println();
    }
}
