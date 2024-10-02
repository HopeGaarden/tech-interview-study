package element.decorators;

import element.component.IElement;

public class PeriodDecorator extends ElementDecorator {
    private int period;

    // period 정보와 IElement를 받아 생성
    public PeriodDecorator(int period, IElement element) {
        super(element);
        this.period = period;
    }

    // 오버라이딩으로 기능(설명) 확장
    @Override
    public String getDescription() {
        return this.decoratedElement.getDescription() + "," + period;
    }
}