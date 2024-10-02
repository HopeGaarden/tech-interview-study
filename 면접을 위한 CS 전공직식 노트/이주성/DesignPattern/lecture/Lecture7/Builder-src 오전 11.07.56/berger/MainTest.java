package berger;

public class MainTest {
    public static void main(String[] args) {
        Burger burger1 = new Burger.BurgerBuilder(2, 1)
                .cheese(true)
                .cheese(true)
                .lettuce(true)
                .tomato(true)
                .bacon(true)
                .build();

        System.out.println(burger1);

        Burger burger2 = new Burger.BurgerBuilder(2,2)
                .cheese(true)
                .build(); // no lettuce, tomato, bacon
        System.out.println(burger2);

        Burger burger3 = new Burger.BurgerBuilder(2,2)
                .bacon(true)
                .build(); // no cheese, lettuce, tomato
        System.out.println(burger3);
    }
}
