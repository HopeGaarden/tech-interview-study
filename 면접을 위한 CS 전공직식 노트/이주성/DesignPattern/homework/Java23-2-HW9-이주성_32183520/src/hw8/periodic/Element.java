package hw8.periodic;


import hw8.state.*;

import java.util.Optional;

public class Element implements MatterState<Element> {
	private int number;
	private String name;
	private String symbol;
	private double weight;
	private int period;
	private int group;
	private String type;
	private Optional<Double> meltingPoint;
	private Optional<Double> boilingPoint;

	private State<Element> gasSate;
	private State<Element> liquidState;
	private State<Element> solidState;
	private State<Element> artificialState;
	private State<Element> state = null;

	// constructor
	public Element(int number, String name, String symbol, double weight, int period, int group, String type) {
		this.number = number;
		this.name = name;
		this.symbol = symbol;
		this.weight = weight;
		this.period = period;
		this.group = group;
		this.type = type;

		this.gasSate = new GasState<>();
		this.liquidState = new LiquidState<>();
		this.solidState = new SolidState<>();
		this.artificialState = new ArtificialState<>();
	}

	// Override
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public State<Element> getArtificialState() {
		return this.artificialState;
	}

	@Override
	public State<Element> getGasState() {
		return this.gasSate;
	}

	@Override
	public State<Element> getLiquidState() {
		return this.liquidState;
	}

	@Override
	public State<Element> getSolidState() {
		return this.solidState;
	}

	@Override
	public State<Element> getState() {
		return this.state;
	}

	@Override
	public void setState(State<Element> state) {
		// 상태 설정
		this.state = state;
		// 설정한 상태에 현재 객체를 설정
		this.state.set(this);
	}

	@Override
	public Optional<Double> getMeltingPoint() {
		return this.meltingPoint;
	}

	@Override
	public void setMeltingPoint(Optional<Double> meltingPoint) {
		this.meltingPoint = meltingPoint;
	}

	@Override
	public Optional<Double> getBoilingPoint() {
		return boilingPoint;
	}

	@Override
	public void setBoilingPoint(Optional<Double> boilingPoint) {
		this.boilingPoint = boilingPoint;
	}

	@Override
	public void setTemperature(double temperature) {
		// 현재 객체의 온도 설정
		this.state.setTemperature(temperature);
	}

	// ToString
	@Override
	public String toString() {
		return "Element{" +
				"number=" + number +
				", name='" + name + '\'' +
				", symbol='" + symbol + '\'' +
				", weight=" + weight +
				", period=" + period +
				", group=" + group +
				", type='" + type + '\'' +
				", meltingPoint=" + meltingPoint +
				", boilingPoint=" + boilingPoint +
				", state=" + state +
				'}';
	}
}