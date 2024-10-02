package element.input;

public enum Decorator {
    SymbolDecorator,
    WeightDecorator,
    TypeDecorator,
    PhaseDecorator,
    PeriodDecorator,
    GroupDecorator;

    //get names()
    public static Decorator names(String input) {
        for(Decorator d : Decorator.values()) {
            if (d.toString().equals(input)) {
                return d;
            }
        }

        // 일치하는 decorator 없으면 null 반환
        return null;
    }
}
