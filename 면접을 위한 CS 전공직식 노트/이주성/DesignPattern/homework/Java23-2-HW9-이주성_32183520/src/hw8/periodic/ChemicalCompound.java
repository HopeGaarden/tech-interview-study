package hw8.periodic;

import hw8.state.*;

import java.util.Map;
import java.util.Optional;

public class ChemicalCompound implements MatterState<ChemicalCompound> {
	private String name;
	private String symbol;
	private Map<Element, Integer> compounds;

	private Optional<Double> meltingPoint;
	private Optional<Double> boilingPoint;

	private State<ChemicalCompound> gasSate;
	private State<ChemicalCompound> liquidState;
	private State<ChemicalCompound> solidState;
	private State<ChemicalCompound> artificialState;
	private State<ChemicalCompound> state = null;

	// 생성자
	public ChemicalCompound(String name, String symbol, Map<Element, Integer> compounds) {
		this.name = name;
		this.symbol = symbol;
		this.compounds = compounds;

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
	public State<ChemicalCompound> getArtificialState() {
		return this.artificialState;
	}

	@Override
	public State<ChemicalCompound> getGasState() {
		return this.gasSate;
	}

	@Override
	public State<ChemicalCompound> getLiquidState() {
		return this.liquidState;
	}

	@Override
	public State<ChemicalCompound> getSolidState() {
		return this.solidState;
	}

	@Override
	public State<ChemicalCompound> getState() {
		return this.state;
	}

	@Override
	public void setState(State<ChemicalCompound> state) {
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
		return this.boilingPoint;
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

	// getter/setter
	public String getSymbol() {
		return this.symbol;
	}

	public Map<Element, Integer> getCompounds() {
		return this.compounds;
	}

    // ToString

	@Override
	public String toString() {
		return "ChemicalCompound{" +
				"name='" + name + '\'' +
				", symbol='" + symbol + '\'' +
				", compounds=" + compounds +
				", state=" + state +
				", meltingPoint=" + meltingPoint +
				", boilingPoint=" + boilingPoint +
				'}';
	}
}
