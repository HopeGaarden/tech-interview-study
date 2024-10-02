package sandwich;

import java.util.List;

public class SandwichBuilder {
	private String name; // optional
	private String bread; // optional
	private String patty; // optional
	private List<String> others; // optional
	private int price; // optional

	private SandwichBuilder() {
		// for classic way to create an object
	}

	private SandwichBuilder(Builder builder) {
		this.name = builder.name;
		this.bread = builder.bread;
		this.patty = builder.patty;
		this.others = builder.others;
		this.price = builder.price;
	}

	public String getName() {
		return name;
	}

	public String getBread() {
		return bread;
	}

	public String getPatty() {
		return patty;
	}

	public List<String> getOthers() {
		return others;
	}

	public int getPrice() {
		return price;
	}

	public static class Builder {
		private String name;
		private String bread;
		private String patty;
		private List<String> others;
		private int price;
		
		public Builder name(String name) {
            this.name = name;
            return this;
        }
		
		public Builder bread(String bread) {
			this.bread = bread;
			return this;
		}
		
		public Builder patty(String patty) {
			this.patty = patty;
			return this;
		}
		
		public Builder price(int price) {
			this.price = price;
			return this;
		}
		
		public Builder others(List<String> others) {
            this.others = others;
            return this;
        }

		public SandwichBuilder build() {
			return new SandwichBuilder(this);
		}
	}

	@Override
	public String toString() {
		return "Sandwich [name=" + name + ", bread=" + bread + ", patty=" + patty + ", others=" + others + ", price="
				+ price + "]";
	}
}
