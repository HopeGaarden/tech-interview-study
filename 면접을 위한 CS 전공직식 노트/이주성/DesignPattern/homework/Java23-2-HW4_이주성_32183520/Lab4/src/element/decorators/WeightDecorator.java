package element.decorators;

import element.component.IElement;

public class WeightDecorator extends ElementDecorator {
    private Double weight;

    // weight 정보와 IElement를 받아 생성
    public WeightDecorator(Double weight, IElement element) {
        super(element);
        this.weight = weight;
    }

    // 오버라이딩으로 기능(설명) 확장
    @Override
    public String getDescription() {
        return this.decoratedElement.getDescription() + "," + weight;
    }
}