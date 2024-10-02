package shape;

import shape.button.Button;
import shape.color.ShapeColor;
import shape.factory.AbstractFactory;
import shape.factory.FactoryProvider;
import shape.ice.Ice;
import shape.ice.IceFactory;
import shape.shape.Shape;

public class MainTest {
    public MainTest() {
        // get color factory
        AbstractFactory<ShapeColor> colorFactory = FactoryProvider.getFactory("COLOR");
        ShapeColor c1 = colorFactory.create("RED");
        c1.color();
        c1 = colorFactory.create("GREEN");
        c1.color();
        c1 = colorFactory.create("BLUE");
        c1.color();

        AbstractFactory<Ice> iceAbstractFactory = new IceFactory();
        Ice a = iceAbstractFactory.create("A");
        a.kiki();

        // get shape factory
        AbstractFactory<Shape> shapeFactory = FactoryProvider.getFactory("SHAPE");
        Shape s1 = shapeFactory.create("Rectangle");
        s1.draw();
        s1 = shapeFactory.create("Triangle");
        s1.draw();
        s1 = shapeFactory.create("Circle");
        s1.draw();

        // get button factory
        AbstractFactory<Button> buttonFactory = FactoryProvider.getFactory("BUTTON");
        Button b1 = buttonFactory.create("PushButton");
        b1.paint();
        b1 = buttonFactory.create("ToggleButton");
        b1.paint();
    }
}
