package element.decorators;

import element.component.IElement;

public class TypeDecorator extends ElementDecorator {
    private String type;

    // type 정보와 IElement를 받아 생성
    public TypeDecorator(String type, IElement element) {
        super(element);
        this.type = type;
    }

    // 오버라이딩으로 기능(설명) 확장
    @Override
    public String getDescription() {
        return this.decoratedElement.getDescription() + "," + type;
    }
}