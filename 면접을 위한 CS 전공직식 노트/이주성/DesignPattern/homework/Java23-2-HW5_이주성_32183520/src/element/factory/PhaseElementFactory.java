package element.factory;

import element.Element;
import element.phase.*;

/*
    팩토리 패턴 적용
    - Element 생성 부분을 캡슐화
*/
public class PhaseElementFactory {
    public static Element getInstance(int number, String name, String symbol, double weight, Phase phase) {

        // phase 타입에 따라 구체 클래스 객체 생성
        // - 객체 생성은 빌더 패턴 사용
        switch (phase) {
            case gas:
                return new GasElement.GasElementBuilder(number, name)
                        .phase(phase)
                        .symbol(symbol)
                        .weight(weight)
                        .build();
            case liq:
                return new LiquidElement.LiquidElementBuilder(number, name)
                        .phase(phase)
                        .symbol(symbol)
                        .weight(weight)
                        .build();
            case solid:
                return new SolidElement.SolidElementBuilder(number, name)
                        .phase(phase)
                        .symbol(symbol)
                        .weight(weight)
                        .build();
            case artificial:
                return new ArtificialElement.ArtificialElementBuilder(number, name)
                        .phase(phase)
                        .symbol(symbol)
                        .weight(weight)
                        .build();
            default:
                return null;
        }
    }
}
