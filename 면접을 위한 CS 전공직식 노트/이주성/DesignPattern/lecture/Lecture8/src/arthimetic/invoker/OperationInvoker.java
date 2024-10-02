package arthimetic.invoker;

import arthimetic.command.Command;
import arthimetic.command.OperationCommand;
import arthimetic.receiver.Operation;

import java.util.ArrayList;
import java.util.List;

// invoker
public class OperationInvoker {
    Operation operation = new Operation();
    List<Command> commands = new ArrayList<>();
    int current = 0;

    public void undo(int levels) {
        System.out.printf("\n------ undo %d levels\n", levels);

        // undo operations
        for (int i = 0; i < levels; i++) {
            if (current > 0) {
                Command command = commands.get(--current);
                command.undo();
            }
        }
    }

    public void redo(int levels) {
        System.out.printf("\n------ redo %d levels\n", levels);

        // redo operations
        for (int i = 0; i < levels; i++) {
            if (current < commands.size() - 1) {
                Command command = commands.get(current++);
                command.execute();
            }
        }
    }

    public void operate(char operator, int operand) {
        // create command operation and execute it
        Command command = new OperationCommand(operation, operator, operand);
        command.execute();

        commands.add(command);
        current++;
    }
}
