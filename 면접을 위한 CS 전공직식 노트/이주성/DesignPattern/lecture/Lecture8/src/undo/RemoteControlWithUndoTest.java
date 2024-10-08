package undo;

import undo.command.*;
import undo.invoker.RemoteControlWithUndo;
import undo.receiver.CeilingFan;

public class RemoteControlWithUndoTest {
 
	public RemoteControlWithUndoTest() {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
//
//		Light livingRoomLight = new Light("Living Room");
//
//		LightOnCommand livingRoomLightOn =
//				new LightOnCommand(livingRoomLight);
//		LightOffCommand livingRoomLightOff =
//				new LightOffCommand(livingRoomLight);
//
//		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
//
//		remoteControl.onButtonWasPushed(0);
//		remoteControl.offButtonWasPushed(0);
//		System.out.println(remoteControl);
//		remoteControl.undoButtonWasPushed();
//		remoteControl.offButtonWasPushed(0);
//		remoteControl.onButtonWasPushed(0);
//		System.out.println(remoteControl);
//		remoteControl.undoButtonWasPushed();

		CeilingFan ceilingFan = new CeilingFan("Living Room");

		CeilingFanMediumCommand ceilingFanMedium =
				new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh =
				new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff =
				new CeilingFanOffCommand(ceilingFan);

		remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);

		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);

		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.undoButtonWasPushed();
		remoteControl.undoButtonWasPushed();
		remoteControl.undoButtonWasPushed();
		remoteControl.undoButtonWasPushed();
		remoteControl.undoButtonWasPushed();

		System.out.println(remoteControl);


//		remoteControl.onButtonWasPushed(1);
//		System.out.println(remoteControl);
//		remoteControl.undoButtonWasPushed();
	}
}
