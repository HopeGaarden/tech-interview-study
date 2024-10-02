package elementFind.receiver;
import elementFind.periodic.PeriodicElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 이름을 기준으로 검색하는 전략
public class NameFinder implements IPeriodicElementFinder {
    private String[] names;

    public NameFinder(String[] names) {
        this.names = names;
    }

    @Override
    public List<PeriodicElement> find(List<PeriodicElement> elements){
        List<PeriodicElement> foundElements = new ArrayList<>();

        // 일치하는 번호의 원소를 찾으면 foundElements에 추가
        for (PeriodicElement element : elements) {
            if (Arrays.stream(names).anyMatch(s -> s.equals(element.getName()))) {
                foundElements.add(element);
            }
        }

        return foundElements;
    }
}
