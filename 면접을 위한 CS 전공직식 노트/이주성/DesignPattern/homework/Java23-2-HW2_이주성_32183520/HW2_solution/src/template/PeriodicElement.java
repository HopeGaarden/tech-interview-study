package template;
public class PeriodicElement {
	private int number;
	private String name;
	private String symbol;
	private double mass;
	private int period;
	private int group;
	private String phase;
	private String type;

	// constructor
	public PeriodicElement(int number, String name, String symbol, double mass, int period, int group, String phase,
			String type) {
		super();
		this.number = number;
		this.name = name;
		this.symbol = symbol;
		this.mass = mass;
		this.period = period;
		this.group = group;
		this.phase = phase;
		this.type = type;
	}

	// getter/setter
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	@Override
	public String toString() {
		return "number=" + number +
				"\nname='" + name + '\'' +
				"\nsymbol='" + symbol + '\'' +
				"\nmass=" + mass +
				"\nperiod=" + period +
				"\ngroup=" + group +
				"\nphase='" + phase + '\'' +
				"\ntype='" + type + '\'';
	}
}