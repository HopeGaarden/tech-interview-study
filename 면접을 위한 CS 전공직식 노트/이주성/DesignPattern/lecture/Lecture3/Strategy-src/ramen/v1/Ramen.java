package ramen.v1;

public class Ramen {
    public static enum CookingMode {
        GENERAL,
        WITH_CHEESE
    }

    private CookingMode mode;

    public Ramen() {
        mode = CookingMode.GENERAL;
    }

    public void setMode(CookingMode mode) {
        this.mode = mode;
    }

    public void cook() {
        switch (mode) {
            case GENERAL:
                cookWithGeneralRecipe();
                break;
            case WITH_CHEESE:
                cookWithCheese();
                break;
        }
    }

    private void cookWithGeneralRecipe() {
        System.out.println("일반 조리법으로 끓이기");
    }
    private void cookWithCheese() {
        System.out.println("라면을 끓인 후에 치즈 넣기");
    }

    public static void main(String[] args) {
        Ramen ramen = new Ramen();

        ramen.cook();

        ramen.setMode(CookingMode.WITH_CHEESE);
        ramen.cook();
    }
}
