package menu.composite;

import menu.component.MenuComponent;

import java.util.ArrayList;

public class Menu extends MenuComponent {
	// 하위 컴포넌트(하위 메뉴 또는 단일 메뉴)를 저장할 리스트
	ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	String name;			// 메뉴 이름
	String description;		// 메뉴 설명
  
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// 컴포넌트 연산 메서드(추상메서드) 구현
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
 
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
 
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}

	// getter
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}

	// 메뉴 정보 출력
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");

		// 하위 컴포넌트에 대해 재귀적으로 print() 호출
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
	}
}
