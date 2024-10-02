package template.finder;

import template.PeriodicElement;
import template.UserInput;
import template.display.IPeriodicElementDisplay;
import template.display.PeriodicElementDisplay;

import java.util.List;

public class NameFinder implements IPeriodicElementFinder {
    @Override
    public void find(List<PeriodicElement> periodicElements) {
        System.out.println("\n... Start searching by name ...");
        System.out.print("Please enter [name] of PeriodicElement: ");

        String input = UserInput.getString();

        // 입력된 문자열의 대문자, 소문자 구분없이 검색하기 위해 전부 소문자로 변환
        String name = input.toLowerCase();

        // 찾았는지 표시
        boolean flag = false;

        for (PeriodicElement pe : periodicElements) {
            // 원소이름도 추출해서 소문자로 변환
            if (pe.getName().toLowerCase().equals(name)) {
                IPeriodicElementDisplay ped = new PeriodicElementDisplay();

                ped.display(pe);
                flag = true;

                break;
            }
        }

        if (!flag) System.out.println("not found");
    }
}
