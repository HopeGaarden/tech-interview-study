package composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite 작동!");
        for (Component child : children) {
            child.operation();
        }
    }
}
