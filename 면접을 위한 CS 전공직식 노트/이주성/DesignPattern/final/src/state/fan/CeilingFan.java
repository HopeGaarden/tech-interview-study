package state.fan;

public class CeilingFan {
    State offState;
    State lowState;
    State mediumState;
    State highState;
    State state = null;

    public CeilingFan() {
        this.offState = new OffState(this);
        this.lowState = new LowState(this);
        this.mediumState = new MediumState(this);
        this.highState = new HighState(this);
        this.state = this.offState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getOffState() {
        return offState;
    }

    public State getLowState() {
        return lowState;
    }

    public State getMediumState() {
        return mediumState;
    }

    public State getHighState() {
        return highState;
    }

    public State getState() {
        return state;
    }

    public void pull() {
        this.state.pull(this);
    }
}
