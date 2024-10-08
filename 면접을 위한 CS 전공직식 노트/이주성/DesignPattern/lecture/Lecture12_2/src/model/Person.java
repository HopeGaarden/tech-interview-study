package model;

public class Person implements Comparable<Person> {
	private int age;
	private String name;
	
	public Person() {
		this(0, null);
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

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Person other) {
		return this.getAge() - other.getAge();
	}
	
	public static String[] columnNames() {
		return new String[] {"Age", "Name"};
	}
}
