package arthimetic.receiver;

// Receiver
public class Operation {
    int value = 0;

    public void operate(char operator, int operand) {
         int preValue = value;

        // 연산자에 따른 사칙연산 수행
        switch (operator) {
            case '+':
                value += operand;
                break;
            case '-':
                value -= operand;
                break;
            case '*':
                value *= operand;
                break;
            case '/':
                value /= operand;
                break;
        }

        System.out.println("operate: " + preValue + " " + operator + " " + operand + " = " + value);
    }
}
