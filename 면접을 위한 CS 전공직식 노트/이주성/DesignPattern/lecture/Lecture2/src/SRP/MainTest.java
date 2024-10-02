package SRP;

import SRP.v1.BookManager;
import SRP.v2.BookDataLoaderFromDB2;
import SRP.v2.BookDataLoaderFromFile2;
import SRP.v2.BookDataViewerConsole2;
import SRP.v2.BookManager2;

public class MainTest {
	// SRP - Single Responsibility Principle
	// 각 클래스는 단 한 개의 책임을 가져야 한다.
	// 클래스의 변경하는 이유는 단 한 개여야 한다.
	public MainTest() {
		// SRP violation
		System.out.println("============================");
		BookManager manager = new BookManager();
		manager.loadFromFile(); // SRP violation
		manager.show();
		manager.loadFromDB(); // SRP violation
		manager.show();

		// SRP
		System.out.println("\n============================");
		BookManager2 manager2 = new BookManager2();
		manager2.setLoader(new BookDataLoaderFromFile2());
		manager2.setViewer(new BookDataViewerConsole2());
		manager2.load();
		manager2.show();
		manager2.setLoader(new BookDataLoaderFromDB2());
		manager2.load();
		manager2.show();
	}

}
