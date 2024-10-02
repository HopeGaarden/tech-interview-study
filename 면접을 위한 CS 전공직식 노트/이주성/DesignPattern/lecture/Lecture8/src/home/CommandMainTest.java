package home;

import home.command.*;
import home.invoker.SimpleRemoteControl;
import home.receiver.Fan;
import home.receiver.Light;
import home.receiver.Television;

public class CommandMainTest {

    public CommandMainTest() {
        SimpleRemoteControl rc = new SimpleRemoteControl();

        Light lamp = new Light();
        Command lampOnCommand = new LightOnCommand(lamp);
        Command lampOffCommand = new LightOffCommand(lamp);

        rc.setCommand("lampOn", lampOnCommand);
        rc.setCommand("lampOff", lampOffCommand);

        Fan fan = new Fan();
        Command fanStartCommand = new FanStartCommand(fan);
        Command fanStopCommand = new FanStopCommand(fan);
        rc.setCommand("fanStart", fanStartCommand);
        rc.setCommand("fanStop", fanStopCommand);

        Television tv = new Television();
        Command tvOnCommand = new TelevisionOnCommand(tv);
        Command tvOffCommand = new TelevisionOffCommand(tv);
        rc.setCommand("tvOn", tvOnCommand);
        rc.setCommand("tvOff", tvOffCommand);

        rc.execute("lampOn");
        rc.execute("lampOff");
        rc.undo("lampOff");
        rc.execute("fanStart");
        rc.undo("fanStart");
        rc.execute("fanStop");
    }

}
