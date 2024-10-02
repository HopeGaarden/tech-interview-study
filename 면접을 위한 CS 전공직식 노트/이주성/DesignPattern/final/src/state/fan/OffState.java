package state.fan;

public class OffState implements State {
    CeilingFan fan;

    public OffState(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void pull(CeilingFan fan) {
        System.out.println("Celing fan is off");
        fan.setState(fan.getLowState());
    }
}
