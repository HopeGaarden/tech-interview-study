package template;

public class Tea extends CaffeineBeverageWithHook{
    @Override
    protected void brew() {
        System.out.println("tea brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("tea add");
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
