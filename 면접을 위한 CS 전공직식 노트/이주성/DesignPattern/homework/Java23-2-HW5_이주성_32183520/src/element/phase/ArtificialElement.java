package element.phase;

import element.Element;

public class ArtificialElement extends Element {
    private final Phase phase; // required

    public Phase getPhase() {
        return phase;
    }

    /*
        ArtificialElementBuilder 필드 값을 설정하고
        super(artificialElementBuilder)으로 Element의 생성자 호출
    */
    private ArtificialElement(ArtificialElementBuilder artificialElementBuilder) {
        super(artificialElementBuilder);
        this.phase = artificialElementBuilder.phase;
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
    public static class ArtificialElementBuilder extends ElementBuilder{
        private Phase phase;

        // 필수 필드인 number, name을 받아 생성
        public ArtificialElementBuilder(int number, String name) {
            super(number, name);
        }

        // phase 설정
        public ArtificialElementBuilder phase(Phase phase) {
            this.phase = phase;
            return this;
        }

        // build 추상 메서드 오버라이드
        @Override
        public Element build() {
            // 최종 객체 생성
            return new ArtificialElement(this);
        }
    }
}
