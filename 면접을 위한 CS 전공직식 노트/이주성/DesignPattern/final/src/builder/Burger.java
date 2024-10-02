package builder;

public class Burger {
    // required
    private final int bun;
    private final int patty;

    // optional
    private final boolean cheese;
    private final boolean lettuce;
    private final boolean tomato;

    private Burger(BurgerBuilder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
    }

    public int getBun() {
        return bun;
    }

    public int getPatty() {
        return patty;
    }

    public boolean isCheese() {
        return cheese;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public boolean isTomato() {
        return tomato;
    }

    @Override
    public String toString() {
        return "builder.Burger{" +
                "bun=" + bun +
                ", patty=" + patty +
                ", cheese=" + cheese +
                ", lettuce=" + lettuce +
                ", tomato=" + tomato +
                '}';
    }

    public static class BurgerBuilder {
        private final int bun;
        private final int patty;

        // optional
        private boolean cheese;
        private boolean lettuce;
        private boolean tomato;

        public BurgerBuilder(int bun, int patty) {
            this.bun = bun;
            this.patty = patty;
        }

        public BurgerBuilder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public BurgerBuilder lettuce(boolean lettuce) {
            this.lettuce = lettuce;
            return this;
        }

        public BurgerBuilder tomato(boolean tomato) {
            this.tomato = tomato;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }

    }
}