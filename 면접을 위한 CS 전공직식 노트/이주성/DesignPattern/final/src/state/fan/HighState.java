package state.fan;

public class HighState implements State {
    CeilingFan fan;

    public HighState(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void pull(CeilingFan fan) {
        System.out.println("Celing fan is on high speed");
        fan.setState(fan.getOffState());
    }
}
