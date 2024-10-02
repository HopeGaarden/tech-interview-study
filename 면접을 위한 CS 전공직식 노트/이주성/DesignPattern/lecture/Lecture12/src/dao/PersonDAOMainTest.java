package dao;


import java.util.Arrays;
import java.util.List;

import dto.Person;

public class PersonDAOMainTest  {

	public PersonDAOMainTest() {
		List<Person> people = Arrays.asList(new Person[] {
				new Person(3000, "Dooly", "SS"),
				new Person(30, "Ddochi", "KK"),
				new Person(25, "Michol", "PP"),
				new Person(20000, "Douner", "CC"),
				new Person(3, "HeeDong", "YY")
		});
		// dao
		PersonList dao = new PersonList(people);

		// print all 
		System.out.println("print all");
		for (Person person : dao.getAll()) {
			System.out.println(person);
		}

		// edit person
		System.out.println("edit");
		Person person = dao.getAll().get(2);
		person.setName("Michael");
		dao.edit(2, person);

		// print all
		System.out.println("print all");
		dao.forEach(System.out::println);

	}

}
