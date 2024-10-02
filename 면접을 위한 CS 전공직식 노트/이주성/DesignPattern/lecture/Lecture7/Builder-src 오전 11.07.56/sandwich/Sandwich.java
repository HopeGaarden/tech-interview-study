package sandwich;

import java.util.List;

public class Sandwich {
	private String name; // optional
	private String bread; // optional
	private String patty; // optional
	private List<String> others; // optional
	private int price; // optional

	public Sandwich() {
		// for classic way to create an object 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBread() {
		return bread;
	}

	public void setBread(String bread) {
		this.bread = bread;
	}

	public String getPatty() {
		return patty;
	}

	public void setPatty(String patty) {
		this.patty = patty;
	}

	public List<String> getOthers() {
		return others;
	}

	public void setOthers(List<String> others) {
		this.others = others;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Sandwich [name=" + name + ", bread=" + bread + ", patty=" + patty + ", others=" + others + ", price="
				+ price + "]";
	}
}
