package shape.factory;

import shape.color.ShapeColor;

public interface AbstractFactory<T> {
    T create(String type);
}
