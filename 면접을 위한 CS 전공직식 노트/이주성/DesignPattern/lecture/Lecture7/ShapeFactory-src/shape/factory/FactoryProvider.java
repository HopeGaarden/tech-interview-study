package shape.factory;

import shape.button.ButtonFactory;
import shape.color.ShapeColorFactory;
import shape.ice.IceFactory;
import shape.shape.ShapeFactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice) {
        switch (choice) {
            case "COLOR":
                return new ShapeColorFactory();
            case "SHAPE":
                return new ShapeFactory();
            case "BUTTON":
                return new ButtonFactory();
            case "ICE":
                return new IceFactory();
            default:
                return null;
        }
    }
}
