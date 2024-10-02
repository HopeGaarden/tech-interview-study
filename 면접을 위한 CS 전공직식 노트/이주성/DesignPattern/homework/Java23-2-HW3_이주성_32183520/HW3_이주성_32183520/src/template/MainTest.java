package template;
import template.input.UserInput;
import template.observers.*;
import template.periodic.PeriodicElement;
import template.periodic.PeriodicElementImporter;
import template.subject.PeriodicTable;

import java.util.List;

// Kyoung Shin Park (Dankook University, Computer Engineering) 2023/09/25
public class MainTest {

	public MainTest() {
		
		// load
		List<PeriodicElement> list = PeriodicElementImporter.loadCSV("PeriodicElements.csv");
		
		// Create the periodic table
		PeriodicTable t = new PeriodicTable();

		// Observers - Listeners Setting
		// NumberListener
		System.out.print("[NumberListener] 관심있는 원소의 번호를 등록하세요. \" \" 공백을 기준으로 구분해주세요. (1~118): ");
		int[] numbers = UserInput.getIntegerArrayBetween(1, 118);
		NumberListener numL = new NumberListener(numbers);

		// SymbolListener
		System.out.print("[SymbolListener] 관심있는 원소의 기호를 등록하세요. \" \" 공백을 기준으로 구분해주세요. : ");
		String[] symbols = UserInput.getStringArray();
		SymbolListener symL = new SymbolListener(symbols);

		// NameListener
		System.out.print("[NameListener] 관심있는 원소의 이름를 등록하세요. \" \" 공백을 기준으로 구분해주세요. : ");
		String[] names = UserInput.getStringArray();
		NameListener nameL = new NameListener(names);

		// PeriodListener
		System.out.print("[PeriodListener] 관심있는 주기 번호를 등록하세요 (1~7): ");
		int period = UserInput.getIntegerBetween(1, 7);
		PeriodListener periodL = new PeriodListener(period);

		// GroupListener
		System.out.print("[GroupListener] 관심있는 그룹 번호를 등록하세요 (null or 1~18): ");
		int group = UserInput.getNullOrIntegerBetween(1, 18);
		GroupListener groupL = new GroupListener(group);

		// PhaseListener
		System.out.print("[PhaseListener] 관심있는 Phase를 등록하세요 (gas/liq/solid/artificial): ");
		String phase = UserInput.getPhase();
		PhaseListener phaseL = new PhaseListener(phase);

		// Add Listeners
		t.addListener(numL);
		t.addListener(symL);
		t.addListener(nameL);
		t.addListener(periodL);
		t.addListener(groupL);
		t.addListener(phaseL);

		// Add elements to the periodic table every 0.5 second
		addElements(list, t);

		// removeListener ...
		System.out.println("removerListener: NumberListener");
		t.removeListener(numL);

		// Add elements to the periodic table every 0.5 second
		addElements(list, t);


	}

	private static void addElements(List<PeriodicElement> list, PeriodicTable t) {
		// Add elements to the periodic table every 0.5 second
		System.out.println("Start adding elements to the periodic table");
		for (PeriodicElement element: list) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("========== Add element : " + element.getName() + " ==========");

			// Add element to the periodic table
			t.addElement(element);
		}
		System.out.println("End adding elements to the periodic table");
	}
}
