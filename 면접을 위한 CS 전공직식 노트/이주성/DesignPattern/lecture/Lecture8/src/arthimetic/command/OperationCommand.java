package arthimetic.command;

import arthimetic.receiver.Operation;

// ConcreteCommand
public class OperationCommand implements Command{
    Operation operation;
    char operator;
    int operand;

    // Getter & Setter
    public OperationCommand(Operation operation, char operator, int operand) {
        this.operation = operation;
        this.operator = operator;
        this.operand = operand;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int getOperand() {
        return operand;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    // Command를 상속받아 구현한 execute 메서드
    // 참조하고 있는 operation의 operate 메서드를 호출한다.
    @Override
    public void execute() {
        operation.operate(operator, operand);
    }

    @Override
    public void undo() {
        // operation undo
        try {
            operation.operate(opposite(operator), operand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private char opposite(char operator) throws Exception {
        switch (operator) {
            case '+': return '-';
            case '-': return '+';
            case '*': return '/';
            case '/': return '*';
            default:
                throw new Exception("operator exception");
        }
    }

    @Override
    public String toString() {
        return "OperationCommand [" +
                "operation=" + operation +
                ", operator=" + operator +
                ", operand=" + operand +
                ']';
    }
}
