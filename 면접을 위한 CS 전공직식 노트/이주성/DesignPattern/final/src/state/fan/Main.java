package state.fan;

public class Main {
    public static void main(String[] args) {
        CeilingFan c = new CeilingFan();

        while (true) {
            c.pull();
        }


    }
}
