package implicit;

public class MenuTestDrive {
	public MenuTestDrive() {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);

		// Use implicit iteration
		waitress.printMenu();
	}
}
