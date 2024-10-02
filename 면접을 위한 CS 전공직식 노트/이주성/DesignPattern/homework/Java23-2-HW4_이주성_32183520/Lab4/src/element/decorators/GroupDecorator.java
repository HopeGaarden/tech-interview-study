package element.decorators;

import element.component.IElement;

public class GroupDecorator extends ElementDecorator {
    private int group;

    // group 정보와 IElement를 받아 생성
    public GroupDecorator(int group, IElement element) {
        super(element);
        this.group = group;
    }

    // 오버라이딩으로 기능(설명) 확장
    @Override
    public String getDescription() {
        return this.decoratedElement.getDescription() + "," + group;
    }
}