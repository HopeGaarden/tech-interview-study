package element;

public abstract class Element {
    /*
        필드 값은 전부 Builder를 이용해 넣어줄 것이므로
        required, optional 상관없이 전부 final로 선언
     */
    private final int number;       // required
    private final String name;      // required
    private final String symbol;    // optional
    private final double weight;    // optional

    // 추상 클래스를 구현한 클래스만 접근 가능하도록 접근 제한자 protected로 설정
    protected Element(ElementBuilder elementBuilder) {
        this.number = elementBuilder.number;
        this.name = elementBuilder.name;
        this.symbol = elementBuilder.symbol;
        this.weight = elementBuilder.weight;
    }

    // Getter 메서드
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getWeight() {
        return weight;
    }

    // ToString
    @Override
    public String toString() {
        return " number: " + number +
                " name: '" + name + '\'' +
                ", symbol: '" + symbol + '\'' +
                ", weight: " + weight;
    }

    /*
        추상 static inner class로 빌더 패턴 적용
        - Element 생성 빌더
    */
    public abstract static class ElementBuilder {
        // required 필드만 final로 선언
        private final int number;       // required
        private final String name;      // required
        private String symbol;          // optional
        private double weight;          // optional

        // final 필드들을 받아 생성하는 생성자 선언
        public ElementBuilder(int number, String name) {
            this.number = number;
            this.name = name;
        }

        // symbol 필드 설정 (Optional)
        public ElementBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        // weight 필드 설정 (Optional)
        public ElementBuilder weight(double weight) {
            this.weight = weight;
            return this;
        }

        // ElementBuilder 구현 클래스에서 구현하도록 abstract 메소드로 선언
        public abstract Element build();
    }
}
