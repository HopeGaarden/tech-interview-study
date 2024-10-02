package element.component;

// Element를 구현한 Concrete Component
public class Element implements IElement {
    // 원소의 번호와 이름만 보유
    // 나머지 속성은 데코레이터로 추가할 예정
    private int number;
    private String name;

    // 생성자: number, name 파라미터
    public Element(int number, String name) {
        this.number = number;
        this.name = name;
    }

    // number,name 형식으로 반환
    @Override
    public String getDescription() {
        return number + "," + name;
    }

}
