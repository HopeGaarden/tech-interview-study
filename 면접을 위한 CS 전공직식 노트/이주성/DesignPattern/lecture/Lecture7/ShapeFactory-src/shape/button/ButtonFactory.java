package shape.button;

import shape.factory.AbstractFactory;

public class ButtonFactory implements AbstractFactory<Button> {
    @Override
    public Button create(String type) {
        switch (type) {
            case "PushButton" :
                return new PushButton();
            case "ToggleButton" :
                return new ToggleButton();
            default:
                return null;
        }
    }

}
