package element.phase;

import element.Element;

public class SolidElement extends Element {
    private final Phase phase; // required

    public Phase getPhase() {
        return phase;
    }

    /*
        SolidElementBuilder 필드 값을 설정하고
        super(solidElementBuilder)으로 Element의 생성자 호출
    */
    private SolidElement(SolidElementBuilder solidElementBuilder) {
        super(solidElementBuilder);
        this.phase = solidElementBuilder.phase;
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
    public static class SolidElementBuilder extends ElementBuilder{
        private Phase phase;

        // 필수 필드인 number, name을 받아 생성
        public SolidElementBuilder(int number, String name) {
            super(number, name);
        }

        // phase 설정
        public SolidElementBuilder phase(Phase phase) {
            this.phase = phase;
            return this;
        }

        // build 추상 메서드 오버라이드
        @Override
        public Element build() {
            // 최종 객체 생성
            return new SolidElement(this);
        }
    }
}
