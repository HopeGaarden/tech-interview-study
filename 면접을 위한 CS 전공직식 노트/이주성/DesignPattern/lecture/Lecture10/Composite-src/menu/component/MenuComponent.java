package menu.component;

public abstract class MenuComponent {
	// 실제 구현이 없으므로 호출했을 경우 UnsupportedOperationException 예외 발생
	// 리프 노도 클래스에서 상속받은 메소드를 직접 사용하지 않도록 하고 구현해 사용하도록 강제

	// Component 연산 -> Menu에서 구체적인 구현
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}

	// Leaf 노드에서 구현할 구체적인 메뉴들의 메서드
	public String getName() {
		throw new UnsupportedOperationException();
	}
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}

	// 구성 요소의 정보 출력 - Leaf, Menu 전부 구현
	public void print() {
		throw new UnsupportedOperationException();
	}
}
