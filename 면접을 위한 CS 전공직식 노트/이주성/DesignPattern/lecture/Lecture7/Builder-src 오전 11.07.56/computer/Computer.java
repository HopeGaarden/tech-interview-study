package computer;

public class Computer {
	// required
	private final String name;
	private final String cpu;
	private final String hdd;
	private final String ram;
	private final String graphicsCard;
	
	// optional
	private final boolean isBluetoothEnabled;
	
	private Computer(ComputerBuilder builder) {
		this.name = builder.name;
		this.cpu = builder.cpu;
		this.hdd = builder.hdd;
		this.ram = builder.ram;
		this.graphicsCard = builder.graphicsCard;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", cpu=" + cpu + ", hdd=" + hdd + ", ram=" + ram + ", graphicsCard="
				+ graphicsCard + ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}

	public static class ComputerBuilder {
		// required
		private String name;
		private String cpu;
		private String hdd;
		private String ram;
		private String graphicsCard;

		// optional
		private boolean isBluetoothEnabled;

		public ComputerBuilder name(String name) {
			this.name = name;
			return this;
		}
		public ComputerBuilder cpu(String cpu) {
			this.cpu = cpu;
			return this;
		}
		public ComputerBuilder hdd(String hdd) {
			this.hdd = hdd;
			return this;
		}
		public ComputerBuilder ram(String ram) {
			this.ram = ram;
			return this;
		}
		public ComputerBuilder graphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}

		public ComputerBuilder isBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}

}

