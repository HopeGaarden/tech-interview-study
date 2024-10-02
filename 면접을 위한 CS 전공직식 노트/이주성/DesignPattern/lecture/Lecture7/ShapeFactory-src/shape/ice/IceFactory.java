package shape.ice;

import shape.factory.AbstractFactory;

public class IceFactory implements AbstractFactory<Ice> {
    @Override
    public Ice create(String type) {
        switch (type) {
            case "A":
                return new AIce();
            default:
                return null;
        }
    }
}
