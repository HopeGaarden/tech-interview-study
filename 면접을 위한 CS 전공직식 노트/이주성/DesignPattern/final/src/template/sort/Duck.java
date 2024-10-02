package template.sort;

public class Duck implements Comparable<Duck> {
    String name;
    double weight;

    public Duck(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Duck o) {
        Duck other = (Duck) o;
        if (this.weight > other.weight) {
            return -1;
        } else if (this.weight == other.weight) {
            return other.name.compareTo(this.name);
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
