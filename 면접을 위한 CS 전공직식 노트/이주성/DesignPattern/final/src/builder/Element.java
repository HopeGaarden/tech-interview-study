package builder;

public abstract class Element {
    private final int number;       // required
    private final String name;      // required
    private final String symbol;    // optional
    private final double weight;    // optional

    protected Element(ElementBuilder builder) {
        this.number = builder.number;
        this.name = builder.name;
        this.symbol = builder.symbol;
        this.weight = builder.weight;
    }

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

    @Override
    public String toString() {
        return "Element{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static abstract class ElementBuilder {
        private final int number;       // required
        private final String name;      // required
        private String symbol;    // optional
        private double weight;    // optional

        public ElementBuilder(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public ElementBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public ElementBuilder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public abstract Element build();
    }
}
