package src.shape.decorator;

import src.shape.Shape;

public class ColorDecorator extends ShapeDecorator {
    private String color;

    public ColorDecorator(String color, Shape decoratedShape) {
        super(decoratedShape);
        this.color = color;

    }

    @Override
    public String getDescription() {
        return this.decoratedShape.getDescription() + " with " + color + " Color";
    }
}
