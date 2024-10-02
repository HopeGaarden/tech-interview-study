package adapter;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DynamicArray<E> implements DataCollection<E> {
    private static final int SIZE = 3;
    int length;
    int capacity;
    E[] data;

    public DynamicArray() {
        this(SIZE);
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.data =(E[]) new Object[capacity];
    }


    // put element to the dynamic array
    @Override
    public void put(E e) {
        // 여유 공간이 없는 경우
        if (this.length == this.capacity) {
            this.capacity++;     // 용량 늘려주기

            // 기존 데이터 복사 후 마지막 인덱스에 원소 추가
            copy(e, this.capacity);

            this.length++;      // 원소 추가했으므로 length++
        }
        // 여유 공간이 있는 경우
        else if (this.length < this.capacity) {
            // 데이터를 넣어준 후 length++
            this.data[length++] = e;
        }
    }

    // 용량이 하나 더 큰 배열에 기존 data[] 복사 후 마지막 인덱스에 데이터 추가하는 메서드
    private void copy(E e, int newCapacity) {
        // E는 제네릭 Type Parameter라서 인스턴스 생성이 불가하므로 Object로 생성한다.
        Object[] newData = new Object[newCapacity];

        // 이전 data[] 그대로 복사
        for (int i = 0; i < newCapacity - 1; i++) {
            newData[i] = this.data[i];
        }

        // 데이터 추가
        newData[newCapacity-1] = e;

        // Object[]를 E[]로 형변환해준 후 data[] update
        this.data = (E[]) newData;
    }

    // insert element at the index
    @Override
    public void insert(int index, E e) {
        // index가 length보다 큰 경우 예외 처리
        if (index > length) {
            throw new ArrayIndexOutOfBoundsException("Error ArrayIndexOutOfBoundsException!!");
        }

        // 여유 공간이 없을 경우
        if (this.length == this.capacity) {
            // 용량 증가
            this.capacity++;

            // 용량을 증가시킨 배열의 index에 요소 추가하는 메서드
            copy(index, e, this.capacity);

            // length 증가
            this.length++;
        }

        // 여유 공간이 있을 경우
        else if (this.length < this.capacity) {
            // 맨 뒤의 원소부터 index까지 하나씩 다음 인덱스로 밀기
            for (int i = this.length - 1; i >= index; i--) {
                this.data[i + 1] = this.data[i];
            }

            // index에 요소 추가
            this.data[index] = e;

            // length 증가
            this.length++;
        }

    }

    private void copy(int index, E e, int newCapacity) {
        Object[] newData = new Object[newCapacity];

        // index 전까지 그대로 복사
        for (int i = 0; i < index; i++) {
            newData[i] = this.data[i];
        }

        // index에 요소 추가
        newData[index] = e;

        // 뒤의 원소 붙여넣기
        for (int i = newCapacity - 1; i > index; i--) {
            newData[i] = this.data[i - 1];
        }

        // Object[]를 E[]로 형변환해준 후 data[] update
        this.data = (E[]) newData;
    }

    // remove element at the index
    @Override
    public void remove(int index) {
        // 삭제하고 싶은 index가 존재하는 요소가 아닐 경우 예외처리
        if (index < 0 || index >= this.length) {
            throw new ArrayIndexOutOfBoundsException("Error ArrayIndexOutOfBounds!!");
        }

        // (index+1)번째 요소 ~ 마지막 요소를 앞으로 하나씩 당겨주기
        for (int i = index + 1; i < this.length; i++) {
            this.data[i - 1] = this.data[i];
        }

        // 마지막 원소 null로 지워주기
        this.data[this.length - 1] = null;

        // length--
        this.length--;
    }

    // get element at the index
    @Override
    public E elemAt(int index) {
        // 조회하고 싶은 요소가 존재하는지 검증
        if (index < 0 || index >= this.length) {
            throw new ArrayIndexOutOfBoundsException("Error ArrayIndexOutOfBounds!!");
        }

        return this.data[index];
    }

    // get the length of dynamic array (# of elements)
    @Override
    public int length() {
        return this.length;
    }

    // remove all elements and reset
    @Override
    public void clear() {

        for (int i = 0; i < this.length; i++) {
            this.data[i] = null;
        }

        // length, capacity 초기화
        this.length = 0;
        this.capacity = SIZE;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayIterator<E>();
    }

    public class DynamicArrayIterator<E> implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return (E) elemAt(index++);
        }

        @Override
        public void remove() {
            if (index > 0) {
                DynamicArray.this.remove(--index);
            } else {
                throw new IllegalStateException("에러");
            }
        }
    }
}
