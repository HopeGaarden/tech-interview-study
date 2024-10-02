package src.shape.decorator;

import src.shape.Shape;

public class PatternDecorator extends ShapeDecorator {
    private String pattern;

    public PatternDecorator(String pattern, Shape decoratedShape) {
        super(decoratedShape);
        this.pattern = pattern;

    }

    @Override
    public String getDescription() {
        return this.decoratedShape.getDescription() + " with " + pattern + " Pattern";
    }
}
