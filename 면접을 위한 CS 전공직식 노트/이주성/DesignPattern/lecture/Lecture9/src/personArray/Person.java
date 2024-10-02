import java.util.Objects;

public class Person {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 객체 비교를 위해 equals 메서드를 오버라이드
    @Override
    public boolean equals(Object o) {
        // 객체와 자기 자신과 동일하면 true 반환
        if (this == o) return true;

        // 클래스가 다르거나 객체가 다르면 false 반환
        if (o == null || getClass() != o.getClass()) return false;

        // Person 타입으로 캐스팅 - 앞에서 클래스가 동일하다는 것을 확인했으므로 안전
        Person person = (Person) o;

        // 두 객체의 age, name 비교 후 둘 다 참이면 true
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName());
    }

    // 객체의 해시 코드를 생성하기 위해 hashCode 메서드를 오버라이드
    @Override
    public int hashCode() {
        // age, name을 기반으로 해시 코드 생성
        return Objects.hash(getAge(), getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
