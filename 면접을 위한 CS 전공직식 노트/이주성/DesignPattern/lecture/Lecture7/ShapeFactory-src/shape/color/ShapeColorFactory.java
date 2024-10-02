package shape.color;

import shape.factory.AbstractFactory;

public class ShapeColorFactory implements AbstractFactory<ShapeColor> {
    @Override
    public ShapeColor create(String type) {
        switch (type) {
            case "RED" :
                return new Red();
            case "GREEN" :
                return new Green();
            case "BLUE" :
                return new Blue();
            default:
                return null;
        }
    }

}
