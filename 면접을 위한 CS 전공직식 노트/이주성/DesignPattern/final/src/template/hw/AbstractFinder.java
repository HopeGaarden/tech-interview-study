package template.hw;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFinder<T> {
    // 조회한 원소 리스트 저장할 변수
    private final List<T> foundList = new ArrayList<>();

    // 템플릿 메서드
    final List<T> find(List<T> list) {
        // 사용자 입력받는 추상 메서드
        Object input = getUserInput();

        for (T e : list) {
            // 조건에 맞는지 확인
            if (predicate(e)) {
                foundList.add(e);
            }
        }

        return foundList;
    }

    protected abstract Object getUserInput();

    protected abstract boolean predicate(T e);
}
