package sandwich.observer;

public class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String orderDetails) {
        System.out.println(name + ", your order is ready: " + orderDetails);
    }
}
