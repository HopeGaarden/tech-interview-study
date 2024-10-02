package sandwich.decorator;

import sandwich.Ingredient;

public class Beef extends SandwichIngredient {
    private String name = "Beef";

    // Beef 데코에이터로 꾸밀 Ingredient를 생성자의 파라미터로 받음
    public Beef(Ingredient ingredient) {
        super(ingredient);
    }

    // ingredient의 getDescription()에 Beef를 붙임
    @Override
    public String getDescription() {
        return super.getDescription() + "," + name;
    }

    // ingredient의 cost()에 Beef 가격 5000원 더함
    @Override
    public int cost() {
        return super.cost() + 5000;
    }
}
