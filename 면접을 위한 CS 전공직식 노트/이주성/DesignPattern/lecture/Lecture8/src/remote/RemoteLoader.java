package remote;

import remote.command.*;
import remote.invoker.RemoteControl;
import remote.receiver.CeilingFan;
import remote.receiver.GarageDoor;
import remote.receiver.Light;
import remote.receiver.Stereo;

public class RemoteLoader {
 
	public RemoteLoader() {
		// invoker
		RemoteControl remoteControl = new RemoteControl();

		// receiver
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan= new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("");
		Stereo stereo = new Stereo("Living Room");

		remoteControl.setCommand(0, livingRoomLight::on, livingRoomLight::off);
		remoteControl.setCommand(0, kitchenLight::on, kitchenLight::off);
		remoteControl.setCommand(0, ceilingFan::high, ceilingFan::off);
		remoteControl.setCommand(0, garageDoor::up, garageDoor::down);
		remoteControl.setCommand(0, stereo::on, stereo::off);

		System.out.println(remoteControl);
 
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		remoteControl.onButtonWasPushed(4);
		remoteControl.offButtonWasPushed(4);
	}
}
