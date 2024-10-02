package template;

public class Coffee extends CaffeineBeverageWithHook{
    @Override
    protected void brew() {
        System.out.println("Coffee brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Coffee add");
    }

    @Override
    protected boolean wantAdd() {
        if (ok()) {
            return true;
        }

        return false;
    }

    private boolean ok() {
        return true;
    }
}
