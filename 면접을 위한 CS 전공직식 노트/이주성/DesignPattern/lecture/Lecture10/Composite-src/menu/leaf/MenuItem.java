package menu.leaf;

import menu.component.MenuComponent;

public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;            // 채식 여부
    double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    // 채식 여부 반환
    public boolean isVegetarian() {
        return vegetarian;
    }

    // 단일 메뉴 정보 출력
    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription());
    }
}
