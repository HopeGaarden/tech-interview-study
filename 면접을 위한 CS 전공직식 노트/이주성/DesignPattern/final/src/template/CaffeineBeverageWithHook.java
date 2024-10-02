package template;

public abstract class CaffeineBeverageWithHook {
    // template method
    final void prepare() {
        boilWater();
        brew();
        pourInCup();
        if (wantAdd()) {
            addCondiments();
        }
    }

    private void boilWater() {
        System.out.println("water");
    }

    private void pourInCup() {
        System.out.println("cup");
    }

    protected abstract void brew();
    protected abstract void addCondiments();

    // hook
    protected boolean wantAdd() {
        return false;
    }
}
