package template.finder;

public class Main {
    public static void main(String[] args) {
        double[] numbers = {-20.5, 87.3, 12.3, 2.5, -5.7, 65.4, -97};

        AbstractFinder finder = new Natural();
        double max = finder.findMax(numbers);
        System.out.println("max = " + max);

        finder = new Abs();
        max = finder.findMax(numbers);
        System.out.println("max = " + max);
    }
}
