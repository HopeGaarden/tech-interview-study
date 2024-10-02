package teacherObserver;

public class Jerry implements Student {
    @Override
    public void update(String message) {
        System.out.println("Jerry received: " + message);
    }
}
