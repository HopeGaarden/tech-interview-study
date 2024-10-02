package adapter;

import java.util.Iterator;

public interface DataCollection<E> extends Iterable<E>{
    void put(E e);

    // 인덱스에 요소 삽입
    void insert(int index, E e);

    // 주어진 인덱스의 요소 삭제
    void remove(int index);

    // 주어진 인덱스의 요소 반환
    E elemAt(int index);

    // 요소의 개수 반환
    int length();

    // 모든 요소 제거 후 초기화
    void clear();
}
