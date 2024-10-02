package element.decorators;

import element.component.IElement;
import element.input.Phase;

public class PhaseDecorator extends ElementDecorator {
    private Phase phase;

    // phase 정보와 IElement를 받아 생성
    public PhaseDecorator(Phase phase, IElement element) {
        super(element);
        this.phase = phase;
    }

    // 오버라이딩으로 기능(설명) 확장
    @Override
    public String getDescription() {
        return this.decoratedElement.getDescription() + "," + phase;
    }
}