package berger;

public class Burger {
    private final int bun; // required
    private final int patty; // required
    private final boolean cheese; // optional
    private final boolean lettuce; // optional
    private final boolean tomato; // optional
    private final boolean bacon; // optional

    private Burger(BurgerBuilder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
        this.bacon = builder.bacon;
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

    public boolean isBacon() {
        return bacon;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "bun=" + bun +
                ", patty=" + patty +
                ", cheese=" + cheese +
                ", lettuce=" + lettuce +
                ", tomato=" + tomato +
                ", bacon=" + bacon +
                '}';
    }

    public static class BurgerBuilder {
        private final int bun; // required
        private final int patty; // required
        private boolean cheese; // optional
        private boolean lettuce; // optional
        private boolean tomato; // optional
        private boolean bacon; // optional

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

        public BurgerBuilder bacon(boolean bacon) {
            this.bacon = bacon;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }
}
