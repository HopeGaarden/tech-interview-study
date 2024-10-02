package element.decorators;


import element.component.IElement;

// Component를 구현한 Decorate 추상 클래스
public abstract class ElementDecorator implements IElement {
    // Component인 IElement 참조
    protected IElement decoratedElement;

    // Decorator로 래핑할 Component를 파라미터로 받아 생성
    public ElementDecorator(IElement element) {
        this.decoratedElement = element;
    }
}
