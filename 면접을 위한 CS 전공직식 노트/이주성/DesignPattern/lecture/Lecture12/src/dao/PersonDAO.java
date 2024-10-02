package dao;

import java.util.List;

import dto.Person;

public interface PersonDAO extends Iterable<Person> {
	Person get(int index);
	List<Person> getAll();
	void add(Person person);
	void edit(int index, Person person);
	void remove(Person person);
	void removeAll();
	int size();
}
