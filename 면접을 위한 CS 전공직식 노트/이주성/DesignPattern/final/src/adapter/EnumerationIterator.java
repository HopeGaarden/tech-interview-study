package adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;

public class EnumerationIterator implements Iterator<Object> {
    // 기존 인터페이스 (어댑티)
    private Enumeration<?> enumeration;

    public EnumerationIterator(Enumeration<?> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }
}
