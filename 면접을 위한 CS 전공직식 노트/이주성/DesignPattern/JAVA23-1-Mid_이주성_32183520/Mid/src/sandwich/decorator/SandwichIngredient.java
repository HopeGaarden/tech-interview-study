package sandwich.decorator;

import sandwich.Ingredient;

// Component인 Ingredient를 구현
public abstract class SandwichIngredient implements Ingredient {
    // Component인 Ingredient의 참조변수를 가짐
    private Ingredient ingredient;

    // 생성자로 데코레이터로 꾸밀 Ingredient을 받음
    public SandwichIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getDescription() {
        return ingredient.getDescription();
    }

    @Override
    public int cost() {
        return ingredient.cost();
    }
}
