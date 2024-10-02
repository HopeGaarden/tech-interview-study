package template.finder;

public class Abs extends AbstractFinder {
    @Override
    protected boolean isLesser(double a, double b) {
        return Math.abs(a) < Math.abs(b);
    }
}
