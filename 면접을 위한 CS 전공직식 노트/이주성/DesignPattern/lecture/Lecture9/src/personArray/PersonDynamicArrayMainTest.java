import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PersonDynamicArrayMainTest {
    public static void main(String[] args) {
        Person[] people = {
                new Person(3000, "Dooly"),
                new Person(30, "Ddochi"),
                new Person(25, "Michol"),
                new Person(20000, "Douner"),
                new Person(3, "Heedong")
        };


        List<Person> list = Arrays.asList(people);
        list.forEach(System.out::println);
        System.out.println();

        // capacity 3개짜리 생성
        PersonDynamicArray arr = new PersonDynamicArray();
        for (Person p : people) {
            arr.add(p);
        }
        System.out.println();
        arr.forEach(System.out::println);
        System.out.println();

        arr.insert(3, new Person(12, "Younghee"));
        arr.forEach(System.out::println);
        System.out.println();

        // remove all
        Iterator<Person> it = arr.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            it.remove();
        }

        System.out.println();
        System.out.println("after remove all");
        arr.forEach(System.out::println);

    }
}
