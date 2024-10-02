package addressbookWithDAOMysql;

import java.util.Arrays;
import java.util.List;

import dto.Person;

public class PersonDBMainTest  {

	public PersonDBMainTest() {
		List<Person> people = Arrays.asList(new Person[] {
				new Person(1, "Dooly", "SS"),
				new Person(3, "Ddochi", "KK"),
				new Person(2, "Michol", "PP"),
				new Person(5, "Douner", "CC"),
				new Person(4, "HeeDong", "YY")
		});
		// dao
		PersonDBMysql dao = new PersonDBMysql();
		people.forEach(p -> dao.insert(p));
		
		// insert
		dao.insert(new Person(7, "KilDong", "WW"));

		// print all 
		System.out.println("print all");
		for (Person p : dao.findAll()) {
			System.out.println(p);
		}

		// edit person
		System.out.println("edit");
		Person person = dao.find(2); // get by id=2
		person.setName("Michael");
		person.setAddress("MM");
		dao.update(person, 2);

		// print all
		System.out.println("print all");
		for (Person p : dao.findAll()) {
			System.out.println(p);
		}
		
	}
}
