package builder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Burger b = new Burger.BurgerBuilder(1, 2)
//                .lettuce(true)
//                .cheese(true)
//                .tomato(false)
//                .build();
//
//        System.out.println(b);
//
//        Sandwich s = new Sandwich.SandwichBuilder()
//                .name("hi")
//                .bread("Grain")
//                .price(3000)
//                .other(Arrays.asList("bacon", "avocado"))
//                .build();
//
//        System.out.println(s);

        Element gas = new GasElement.GasElementBuilder(1, "hi")
                .phase("phase")
                .symbol("symbol")
                .weight(34L)
                .build();

        System.out.println(gas);
    }
}
