/*
 *   과목: 자바 프로그래밍2
 *   교수님: 박경신 교수님
 *   학과: 컴퓨터공학과
 *   학번: 32183520
 *   이름: 이주성
 */

package sandwich;

import sandwich.decorator.*;
import sandwich.factory.OtherIngredientFactory;
import sandwich.observer.Customer;
import sandwich.observer.SandwichOrderSubject;
import sandwich.recipe.ColdRecipe;
import sandwich.recipe.GrilledRecipe;

public class MainTest {
    public MainTest() {

        // Create a sandwich order subject
        SandwichOrderSubject s = new SandwichOrderSubject();

        // Subscribe customers "Tom" & "Jerry" to dorder notifications
        Customer tom = new Customer("Tom");
        Customer jerry = new Customer("Jerry");

        // subscribe
        s.addObserver(tom);
        s.addObserver(jerry);


        // Create sandwich
        Ingredient sandwich = new Sandwich(new GrilledRecipe());
        // Add decorator
        sandwich = new WholeGrainBread(sandwich);
        // Add decorator
        sandwich = new Beef(sandwich);
        // Add decorator
        sandwich = new SwissCheese(sandwich);
        // Factory Pattern 사용
        String[] ingredient = {"Lettuce", "Onion", "Tomato"};
        for (String in : ingredient) {
            sandwich = OtherIngredientFactory.getInstance(in, sandwich);
        }
        sandwich = OtherIngredientFactory.getInstance("other", sandwich);

        // Notify orderDetails
        String orderDetails = sandwich.getDescription() + " " + sandwich.cost();
        s.notifyObservers(orderDetails);

        // Unsubscribe "Tom" & "Jerry"
        s.removeObserver(tom);
        s.removeObserver(jerry);

        // subscribe "Mitty" to order notifications
        Customer mitty = new Customer("Mitty");
        s.addObserver(mitty);

        // Create sandwich
        Ingredient sandwich2 = new Sandwich(new ColdRecipe());
        sandwich2 = new OatmealBread(sandwich2);
        sandwich2 = new Ham(sandwich2);
        sandwich2 = new AmericanCheese(sandwich2);
        // Factory Pattern 사용
        sandwich2 = OtherIngredientFactory.getInstance("Lettuce", sandwich2);
        sandwich2 = OtherIngredientFactory.getInstance("Tomato", sandwich2);
        sandwich2 = OtherIngredientFactory.getInstance("other", sandwich2);

        // notify orderDetails2
        String orderDetails2 = sandwich2.getDescription() + " " + sandwich2.cost();
        s.notifyObservers(orderDetails2);

    }
}
