package addressbookWithList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dto.Person;

public class PersonList implements PersonDAO, Iterable<Person> {
	private List<Person> pList = null;

	public PersonList() {
		pList = new ArrayList<>();
	}
	
	public PersonList(List<Person> list) {
		setList(list);
	}

	public List<Person> getList() {
		return pList;
	}

	public void setList(List<Person> list) {
		this.pList = list;
	}

	// add
	@Override
	public void insert(Person person) {
		pList.add(person);
	}
	
	// findAll
	@Override
	public List<Person> findAll() {
		return this.pList;
	}

	// find by id
	@Override
	public Person find(int id) {
		Person person = null;
		for (Person p : pList) {
			if (p != null && p.getId() == id) {
				person = p;
				break;
			}
		}
		return person;
	}

	// find by name
	public Person find(String name) {
		Person person = null;
		for (Person p : pList) {
			if (p != null && p.getName().equals(name)) {
				person = p;
				break;
			}
		}
		return person;
	}

	// update by id
	@Override
	public void update(Person person, int id) {
		int index = this.pList.indexOf(find(id));
		this.pList.set(index, person);		
	}
	
	// update by name
	public void update(Person person, String name) {
		int index = this.pList.indexOf(find(name));
		this.pList.set(index, person);
	}

	// delete by Person 
	@Override
	public void delete(Person person) {
		Iterator<Person> it = pList.iterator();
		while (it.hasNext()) {
		    Person p = it.next();
		    if (p == person) {
				it.remove();
		    }
		}
	}
	
	// delete by id 
	@Override
	public void delete(int id) {
		this.pList.removeIf(p -> p.getId() == id);
	}

	// delete by name 
	@Override
	public void delete(String name) {
		this.pList.removeIf(p -> p.getName().contentEquals(name));
	}
	
	// delete all 
	public void deleteAll() {
		Iterator<Person> it = pList.iterator();
		while (it.hasNext()) {
		    it.next();
			it.remove();
		}
	}
	
	// iterator
	public Iterator<Person> iterator() {
		return this.pList.iterator();
	}
}
