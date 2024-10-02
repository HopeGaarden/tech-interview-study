package template.finder;

import template.PeriodicElement;
import template.UserInput;
import template.display.IPeriodicElementDisplay;
import template.display.PeriodicElementDisplay;

import java.util.List;

public class SymbolFinder implements IPeriodicElementFinder {
    @Override
    public void find(List<PeriodicElement> periodicElements) {
        System.out.println("\n... Start searching by symbol ...");
        System.out.print("Please enter [symbol] of PeriodicElement: ");

        String input = UserInput.getString();

        // 입력된 문자열의 대문자, 소문자 구분없이 검색하기 위해 전부 소문자로 변환
        String name = input.toLowerCase();

        // 찾았는지 표시
        boolean flag = false;

        for (PeriodicElement pe : periodicElements) {
            if (pe.getSymbol().toLowerCase().equals(name)) {
                IPeriodicElementDisplay ped = new PeriodicElementDisplay();

                ped.display(pe);
                flag = true;

                break;
            }
        }

        if (!flag) System.out.println("not found");

    }
}
