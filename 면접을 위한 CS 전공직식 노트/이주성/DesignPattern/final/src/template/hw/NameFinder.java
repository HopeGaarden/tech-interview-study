package template.hw;


public class NameFinder extends AbstractFinder<String> {

    @Override
    protected Object getUserInput() {
        return null;
    }

    @Override
    protected boolean predicate(String e) {
        return false;
    }
}
