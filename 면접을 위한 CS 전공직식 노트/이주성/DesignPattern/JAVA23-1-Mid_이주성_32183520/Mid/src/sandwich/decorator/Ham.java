package sandwich.decorator;

import sandwich.Ingredient;

public class Ham extends SandwichIngredient {

    private String name = "Ham";

    // 데코에이터로 꾸밀 Ingredient를 생성자의 파라미터로 받음
    public Ham(Ingredient ingredient) {
        super(ingredient);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "," + name;
    }

    @Override
    public int cost() {
        return super.cost() + 4000;
    }
}
