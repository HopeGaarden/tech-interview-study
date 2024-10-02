package builder;

public class GasElement extends Element{
    private final String phase;

    private GasElement(GasElementBuilder builder) {
        super(builder);
        this.phase = builder.phase;
    }

    public String getPhase() {
        return phase;
    }

    @Override
    public String toString() {
        return "GasElement{" +
                "phase='" + phase + '\'' +
                '}' + super.toString();
    }

    public static class GasElementBuilder extends ElementBuilder {
        private String phase;

        public GasElementBuilder(int number, String name) {
            super(number, name);
        }

        public GasElementBuilder phase(String phase) {
            this.phase = phase;
            return this;
        }

        public Element build() {
            return new GasElement(this);
        }
    }

}
