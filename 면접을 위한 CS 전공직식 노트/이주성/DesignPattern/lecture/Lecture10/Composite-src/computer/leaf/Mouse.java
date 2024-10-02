package computer.leaf;

import computer.component.ComputerDevice;

public class Mouse extends ComputerDevice {
	private int price;
	private int power;
	
	public Mouse(int price, int power) {
		this.price = price;
		this.power = power;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
}
