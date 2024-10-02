package composite;

public class Main {
    public static void main(String[] args) {
        Leaf c = new Leaf();
        Leaf a = new Leaf();
        Leaf k = new Leaf();
        Leaf 가 = new Leaf();

        Composite en = new Composite();
        Composite lang = new Composite();
        Composite ko = new Composite();
        lang.add(ko);
        lang.add(en);

        ko.add(가);
        en.add(c);
        en.add(a);
        en.add(k);


        lang.operation();
    }
}
