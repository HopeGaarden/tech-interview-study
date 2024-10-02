package shape.shape;

import shape.factory.AbstractFactory;
import shape.shape.Circle;
import shape.shape.Rectangle;
import shape.shape.Shape;
import shape.shape.Triangle;

public class ShapeFactory implements AbstractFactory<Shape> {
    @Override
    public Shape create(String type) {
        switch (type) {
            case "Rectangle" :
                return new Rectangle();
            case "Triangle" :
                return new Triangle();
            case "Circle" :
                return new Circle();
            default:
                return null;
        }
    }
}