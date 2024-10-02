package template.finder;

public class Natural extends AbstractFinder {
    @Override
    protected boolean isLesser(double a, double b) {
        return a < b;
    }
}
