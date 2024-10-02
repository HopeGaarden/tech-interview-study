import java.security.PublicKey;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PersonDynamicArray implements Iterable<Person>{
    private Person[] data = null;
    private int size = 0;
    private int capacity = 0;

    public PersonDynamicArray() {
        // 디폴트는 3
        this(3);
    }

    public PersonDynamicArray(int capacity) {
        this.capacity = capacity;
        this.data = new Person[this.capacity];
    }

    public Person[] getData() {
        return data;
    }

    public int getCapacity() {
        return capacity;
    }

    public Person get(int index) {
        // if index in the array bounds
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
        // 공간이 있을 경우
        if (this.size < this.capacity) {
            this.data[size++] = person;
        } else {
            System.out.println("dynamic array increase size: " + size);
            this.size++;
            this.capacity++;
            copy(person, this.capacity);
        }
    }

    // increase array size & copy all data
    private void copy(Person person, int newCapacity) {
        Person[] newData = new Person[newCapacity];

        // copy before newSize - 1
        for (int i = 0; i < newCapacity - 1; i++) {
            newData[i] = this.data[i];
        }

        // copy person at the end
        newData[newCapacity - 1] = person;

        // update data with newData
        this.data = newData;
    }

    // insert
    public void insert(int index, Person person) {
        // 공간이 남았을 경우
        if (this.size + 1 < this.capacity) {
            for (int i = this.size - 1; i > index - 1; i--) {
                this.data[i + 1] = this.data[i];
            }

            // insert new person
            this.data[index - 1] = person;
        } else {
            System.out.println("insert: dynamic array increase capacity: " + capacity);
            this.size++;
            this.capacity++;
            copy(index, person, this.capacity);
        }
    }

    private void copy(int index, Person person, int newCapacity) {
        Person[] newData = new Person[newCapacity];

        // copy before index
        for (int i = 0; i < index; i++) {
            newData[i] = this.data[i];
        }

        // copy person at the index
        newData[index] = person;

        // copy after index
        for (int i = newCapacity - 1; i > index; i--) {
            newData[i] = this.data[i - 1];
        }

        // update data with newData
        this.data = newData;
    }

    public void remove(int index) {
        if (index <= 0 && index > size) {
            System.out.println("Error: ArrayIndexOutOfBounds");
        } else {
            for (int i = index; i < size - 1; i++) {
                this.data[i] = this.data[i + 1];
            }
            this.size--;
            this.data[size] = null;
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
            // next() 메서드를 통해 반환된 요소를 제거하기 위해선 next()에서 ++해준 인덱스를 --해줘야 함
            PersonDynamicArray.this.remove(--index);
        }
    }
}
