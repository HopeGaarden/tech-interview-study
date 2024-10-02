package template;

import template.finder.*;

import java.util.List;

// Kyoung Shin Park (Dankook University, Computer Engineering) 2023/09/01

public class MainTest {

    public MainTest() {

        // load
        List<PeriodicElement> list = PeriodicElementImporter.loadCSV("PeriodicElements.csv");

        // 모든 원소 기호 출력
        // System.out.println("\nlist all");
        // list.forEach(System.out::println);


        while (true) {
            IPeriodicElementFinder finder = UserInput.getFilter();
            if (finder == null) {
                break;
            }

            PeriodicElementFinder pef = new PeriodicElementFinder(finder);

            // 검색 수행
            pef.find(list);

            System.out.println("\ndone..\n");
        }
    }

}
