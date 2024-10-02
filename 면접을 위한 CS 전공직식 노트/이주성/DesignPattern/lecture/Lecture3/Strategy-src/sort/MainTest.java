package sort;

import java.util.Arrays;
import java.util.Comparator;

public class MainTest {

    public static Comparator<Person> comp = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            if (o1.getAge() - o2.getAge() > 0) {
                return 1;
            } else if (o1.getAge() - o2.getAge() == 0) {
                return o2.getName().compareTo(o1.getName());
            } else {
                return -1;
            }
        }
    };

    public MainTest() {
        Person[] people = {
                new Person(3000, "A"),
                new Person(25, "B"),
                new Person(3, "C"),
                new Person(3000, "D"),
                new Person(3, "E")
        };


        System.out.println("original people");
        for (var p : people) {
            System.out.println(p);
        }
        System.out.println();

        Arrays.sort(people, comp);
        System.out.println("comp");
        for (var p : people) {
            System.out.println(p);
        }

        Arrays.sort(people);
        System.out.println("people src.sort by default (Comparable interface)");
        for (var p : people) {
            System.out.println(p);
        }
        System.out.println();

        Arrays.sort(people, new NameComparator());
        System.out.println("people src.sort by Name (Comparator interface)");
        for (var p : people) {
            System.out.println(p);
        }
        System.out.println();

        Arrays.sort(people, new AgeDescComparator());
        System.out.println("people desc src.sort by Age (Comparator interface)");
        for (var p : people) {
            System.out.println(p);
        }
        System.out.println();
    }
}
