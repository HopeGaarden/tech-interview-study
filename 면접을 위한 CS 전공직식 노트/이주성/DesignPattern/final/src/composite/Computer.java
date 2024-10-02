package composite;

import java.util.ArrayList;
import java.util.List;

public class Computer extends ComputerDevice {

    private List<ComputerDevice> children = new ArrayList<>();

    public List<ComputerDevice> getChildren() {
        return children;
    }

    public void add(ComputerDevice component) {
        this.children.add(component);
    }

    public void remove(ComputerDevice component) {
        this.children.remove(component);
    }

    @Override
    public int getPrice() {
        return children.stream().mapToInt(ComputerDevice::getPrice).sum();
    }

    @Override
    public int getPower() {
        return children.stream().mapToInt(ComputerDevice::getPower).sum();
    }
}
