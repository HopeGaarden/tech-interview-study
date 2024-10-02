package state.fan;

public class MediumState implements State {
    CeilingFan fan;

    public MediumState(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void pull(CeilingFan fan) {
        System.out.println("Celing fan is on medium speed");
        fan.setState(fan.getHighState());
    }
}
