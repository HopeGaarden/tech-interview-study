package simpleremote.command;

import simpleremote.command.Command;
import simpleremote.receiver.GarageDoor;

public class GarageDoorCloseCommand implements Command {
	GarageDoor garageDoor;

	public GarageDoorCloseCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.down();
	}
}
