package element.phase;

import element.Element;

public class LiquidElement extends Element {
    private final Phase phase; // required

    public Phase getPhase() {
        return phase;
    }

    /*
        LiquidElementBuilder로 필드 값을 설정하고
        super(LiquidElementBuilder)으로 Element의 생성자 호출
    */
    private LiquidElement(LiquidElementBuilder liquidElementBuilder) {
        super(liquidElementBuilder);
        this.phase = liquidElementBuilder.phase;
    }

    // toString에 타입 정보 포함
    @Override
    public String toString() {
        return  "[" + phase + " Element]" + super.toString();
    }

    /*
        static inner class로 빌더 패턴 적용
        - LiquidElement 생성
    */
    public static class LiquidElementBuilder extends ElementBuilder{
        private Phase phase;

        // 필수 필드인 number, name을 받아 생성
        public LiquidElementBuilder(int number, String name) {
            super(number, name);
        }

        // phase 설정
        public LiquidElementBuilder phase(Phase phase) {
            this.phase = phase;
            return this;
        }

        // build 추상 메서드 오버라이드
        @Override
        public Element build() {
            // 최종 객체 생성
            return new LiquidElement(this);
        }
    }
}
