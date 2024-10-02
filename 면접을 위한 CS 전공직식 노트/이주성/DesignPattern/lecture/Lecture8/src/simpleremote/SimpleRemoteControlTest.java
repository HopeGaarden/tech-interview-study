package simpleremote;

import simpleremote.command.GarageDoorCloseCommand;
import simpleremote.command.GarageDoorOpenCommand;
import simpleremote.command.LightOffCommand;
import simpleremote.command.LightOnCommand;
import simpleremote.invoker.SimpleRemoteControl;
import simpleremote.receiver.GarageDoor;
import simpleremote.receiver.Light;

public class SimpleRemoteControlTest {
	public SimpleRemoteControlTest() {
		SimpleRemoteControl remote = new SimpleRemoteControl(); // invoker
		Light light = new Light(); // receiver
		GarageDoor garageDoor = new GarageDoor(); // receiver

		LightOnCommand lightOn = new LightOnCommand(light); // command
		LightOffCommand lightOff = new LightOffCommand(light); // command
		GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor); // command
		GarageDoorCloseCommand garageClose = new GarageDoorCloseCommand(garageDoor); // command

		remote.setCommand(lightOn); // set command
		remote.buttonWasPressed(); // lightOn command execute
		remote.setCommand(garageOpen); // set command
		remote.buttonWasPressed(); // garageOpen command execute
		remote.setCommand(lightOff); // set command
		remote.buttonWasPressed(); // lightOff command execute
		remote.setCommand(garageClose); // set command
		remote.buttonWasPressed(); // garageClose execute
    }
}
