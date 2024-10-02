package dto;
import java.util.Objects;

public class Person implements Comparable<Person> {
	private int id;
	private String name;
	private String address;

	public Person() {
	}

	public Person(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person id(int id) {
		setId(id);
		return this;
	}

	public Person name(String name) {
		setName(name);
		return this;
	}

	public Person address(String address) {
		setAddress(address);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Person)) {
			return false;
		}
		Person person = (Person) o;
		return id == person.id && Objects.equals(name, person.name) && Objects.equals(address, person.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, address);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int compareTo(Person o) {
		return this.getId() - o.getId();
	}

}
