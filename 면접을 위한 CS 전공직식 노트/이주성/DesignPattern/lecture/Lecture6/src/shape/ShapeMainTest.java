package src.shape;

import src.shape.decorator.ColorDecorator;
import src.shape.decorator.PatternDecorator;

public class ShapeMainTest {
    public ShapeMainTest() {
        Shape s = new Circle();
        s.draw();

        // Rectangle + Red Color + Check Pattern
        Shape r = new PatternDecorator("check", new ColorDecorator("red", new Rectangle()));
        System.out.println(r.getDescription());

        // Triangle + Red Color + Green Color + Blue Color
        Shape t = new ColorDecorator("blue", new ColorDecorator("Green", new ColorDecorator("Red", new Triangle())));
        System.out.println(t.getDescription());
        t.draw();

    }
}
