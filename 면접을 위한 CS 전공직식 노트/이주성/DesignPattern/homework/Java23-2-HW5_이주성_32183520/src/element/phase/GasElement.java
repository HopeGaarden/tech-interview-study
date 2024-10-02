package element.phase;

import element.Element;

public class GasElement extends Element {
    private final Phase phase; // required

    public Phase getPhase() {
        return phase;
    }

    /*
        GasElementBuilder로 필드 값을 설정하고
        super(gasElementBuilder)으로 Element의 생성자 호출
    */
    private GasElement(GasElementBuilder gasElementBuilder) {
        super(gasElementBuilder);
        this.phase = gasElementBuilder.phase;
    }

    // toString에 타입 정보 포함
    @Override
    public String toString() {
        return  "[" + phase + " Element]" + super.toString();
    }

    /*
        static inner class로 빌더 패턴 적용
        - GasElement 생성
    */
    public static class GasElementBuilder extends ElementBuilder{
        private Phase phase;

        // 필수 필드인 number, name을 받아 생성
        public GasElementBuilder(int number, String name) {
            super(number, name);
        }

        // phase 설정
        public GasElementBuilder phase(Phase phase) {
            this.phase = phase;
            return this;
        }

        // build 추상 메서드 오버라이드
        @Override
        public Element build() {
            // 최종 객체 생성
            return new GasElement(this);
        }
    }
}