package computer.composite;

import computer.component.ComputerDevice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer extends ComputerDevice {
	private List<ComputerDevice> components = new ArrayList<>();

	public List<ComputerDevice> getComponents() {
		return components;
	}

	public void addComponent(ComputerDevice component) {
		this.components.add(component);
	}

	public void removeComponent(ComputerDevice component) {
		this.components.remove(component);
	}

	public int getPrice() {
		return components.stream().mapToInt(ComputerDevice::getPrice).sum();
	}

	public int getPower() {
		return components.stream().mapToInt(ComputerDevice::getPower).sum();
	}
}
