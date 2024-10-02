package arthimetic;

import arthimetic.invoker.OperationInvoker;

public class MainTest {
    public MainTest() {
        int a = 100;
        int b = 50;
        int c = 10;
        int d = 2;

        int e = 0 + a;
        System.out.printf("e = 0 + %d = %d\n", a, e);

        int f = e - b;
        System.out.printf("f = %d - %d = %d\n", e, b, f);

        int g = f * c;
        System.out.printf("g = %d * %d = %d\n", f, c, g);

        int h = g / d;
        System.out.printf("h = %d / %d = %d\n\n", g, d, h);

        // create Invoker
        OperationInvoker invoker = new OperationInvoker();

        // invoker operate
        invoker.operate('+', a);
        invoker.operate('-', b);
        invoker.operate('*', c);
        invoker.operate('/', d);

        // undo 4 commands
        invoker.undo(4);

        // redo 3 commands
        invoker.redo(3);
    }
}
