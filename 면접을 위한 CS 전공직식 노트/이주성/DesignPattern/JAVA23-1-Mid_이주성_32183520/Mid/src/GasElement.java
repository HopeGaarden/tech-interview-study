public class GasElement extends Element {
    private final String phase;

    private GasElement(GasElementBuilder builder) {
        super(builder);
        this.phase = builder.phase;
    }

    public static class GasElementBuilder extends ElementBuilder{
        private final String phase;

        public GasElementBuilder(int number, String name, String phase) {
            super(number, name);
            this.phase = phase;
        }

        @Override
        public GasElement build() {
            return new GasElement(this);
        }
    }
}
