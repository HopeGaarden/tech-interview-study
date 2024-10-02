package state.fan;

public class LowState implements State {
    CeilingFan fan;

    public LowState(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void pull(CeilingFan fan) {
        System.out.println("Celing fan is on low speed");
        fan.setState(fan.getMediumState());
    }
}
