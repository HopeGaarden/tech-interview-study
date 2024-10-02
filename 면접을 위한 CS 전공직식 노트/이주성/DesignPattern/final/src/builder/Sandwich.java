package builder;

import java.util.List;

public class Sandwich {
    private final String name;
    private final String bread;
    private final List<String> other;
    private final int price;

    private Sandwich(SandwichBuilder builder) {
        this.name = builder.name;
        this.bread = builder.bread;
        this.other = builder.other;
        this.price = builder.price;
    }

    public String getName() {
        return name;
    }

    public String getBread() {
        return bread;
    }

    public List<String> getOther() {
        return other;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "name='" + name + '\'' +
                ", bread='" + bread + '\'' +
                ", other=" + other +
                ", price=" + price +
                '}';
    }

    public static class SandwichBuilder {
        private String name;
        private String bread;
        private List<String> other;
        private int price;

        public SandwichBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SandwichBuilder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public SandwichBuilder other(List<String> other) {
            this.other = other;
            return this;
        }

        public SandwichBuilder price(int price) {
            this.price = price;
            return this;
        }

        public Sandwich build() {
            return new Sandwich(this);
        }
    }
}
