package ramen.v2;

public class MainTest {
    public static void main(String[] args) {
        Ramen2 ramen2 = new GeneralRamen();
        ramen2.cook();
        ramen2 = new CheeseRamen();
        ramen2.cook();
    }
}
