package src.shape.decorator;

import src.shape.Shape;

public abstract class ShapeDecorator extends Shape {
    protected Shape decoratedShape;

    protected ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
}
