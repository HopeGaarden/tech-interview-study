public abstract class Element {
    private final int number;
    private final String name;
    private final String symbol;
    private final double weight;

    protected Element(ElementBuilder builder) {
        this.number = builder.number;
        this.name = builder.name;
        this.symbol = builder.symbol;
        this.weight = builder.weight;
    }

    public abstract static class ElementBuilder {
        private final int number;
        private final String name;
        private String symbol;
        private double weight;

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
