package elementFind.receiver;


import elementFind.periodic.PeriodicElement;

import java.util.List;

// Strategy Pattern
public interface IPeriodicElementFinder {
    // PeriodicElement 리스트를 찾는 find 메서드
    // 나중에 구체 클래스에서 오버라이딩해 사용
    List<PeriodicElement> find(List<PeriodicElement> elements);
}