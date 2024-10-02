package element.decorators;

import element.component.IElement;

public class SymbolDecorator extends ElementDecorator {
    private String symbol;

    // symbol 정보와 IElement를 받아 생성
    public SymbolDecorator(String symbol, IElement element) {
        super(element);
        this.symbol = symbol;
    }

    // 오버라이딩으로 기능(설명) 확장
    @Override
    public String getDescription() {
        return this.decoratedElement.getDescription() + "," + symbol;
    }
}