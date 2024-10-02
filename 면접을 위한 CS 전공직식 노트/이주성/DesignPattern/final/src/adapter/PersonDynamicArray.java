package adapter;

import java.util.Iterator;
import java.util.NoSuchElementException;

// 타겟: Iterable<Person>
public class PersonDynamicArray implements Iterable<Person> {
    // 어댑티
    private Person[] data = null;
    private int size = 0;
    private int capacity = 0;

    public PersonDynamicArray() {
        this(3);
    }

    public PersonDynamicArray(int capacity) {
        this.capacity = capacity;
        this.data = new Person[this.capacity];
    }

    public Person get(int index) {
        if (index >= 0 && index < this.size) {
            return this.data[index];
        }

        return null;
    }

    public void addAll(Person[] persons) {
        for (Person p : persons) {
            add(p);
        }
    }

    public void add(Person person) {
        if (this.size < this.capacity) {
            this.data[size++] = person;
        } else {
            this.size++;
            this.capacity++;
            copy(person, capacity);
        }
    }

    private void copy(Person person, int newCapacity) {
        Person[] newData = new Person[newCapacity];

        for (int i = 0; i < newCapacity - 1; i++) {
            newData[i] = this.data[i];
        }

        newData[newCapacity -1] = person;

        this.data = newData;
    }

    public void insert(int index, Person person) {
        if (this.size < this.capacity) {
            for (int i = this.size - 1; i >= index; i--) {
                this.data[i + 1] = this.data[i];
            }

            this.data[index - 1] = person;
        } else {
            this.size++;
            this.capacity++;
            copy(index, person, this.capacity);
        }

    }

    private void copy(int index, Person person, int newCapacity) {
        Person[] newData = new Person[newCapacity];

        for (int i = 0; i < index; i++) {
            newData[i] = this.data[i];
        }

        for (int i = newCapacity - 1; i > index; i--) {
            newData[i] = this.data[i - 1];
        }

        newData[index] = person;

        this.data = newData;
    }

    public void remove(int index) {
        if (index <= this.size || index > 0) {
            for (int i = index; i < size - 1; i++) {
                this.data[i] = this.data[i + 1];
            }
            this.size--;
            this.data[size] = null;
        } else {
            System.out.println("Error: ArrayIndexOutOfBounds");
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonDynamicArrayIterator();
    }

    private class PersonDynamicArrayIterator implements Iterator<Person> {
        private int index = 0;


        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Person next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return get(index++);
        }

        @Override
        public void remove() {
            PersonDynamicArray.this.remove(--index);
        }
    }

}
