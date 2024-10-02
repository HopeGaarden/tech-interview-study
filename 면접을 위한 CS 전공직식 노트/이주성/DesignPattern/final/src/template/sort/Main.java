package template.sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("Daffy", 8),
                new Duck("Howard", 7), new Duck("Louie", 2),
                new Duck("Donald", 7), new Duck("Huey", 5)};

        Arrays.sort(ducks);

        for (Duck d : ducks) {
            System.out.println(d);
        }
    }
}
