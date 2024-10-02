package undo.command;

import undo.command.Command;

public class NoCommand implements Command {
	public void execute() { }
	public void undo() { }
}
