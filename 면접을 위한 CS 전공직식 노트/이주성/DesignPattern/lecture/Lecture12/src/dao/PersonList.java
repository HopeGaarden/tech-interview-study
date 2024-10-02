package dao;

import java.util.Iterator;
import java.util.List;

import dto.Person;

public class PersonList implements PersonDAO {
	private List<Person> pList = null;

	public PersonList() {
		this(null);
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

	// get
	@Override
	public Person get(int index) {
		return this.pList.get(index);
	}

	// getAll
	@Override
	public List<Person> getAll() {
		return this.pList;
	}

	// add
	@Override
	public void add(Person person) {
		pList.add(person);
	}
	
	// edit
	@Override
	public void edit(int index, Person person) {
		this.pList.set(index, person);
	}
	
	// remove all 
	@Override
	public void removeAll() {
		Iterator<Person> it = pList.iterator();
		while (it.hasNext()) {
		    it.next();
			it.remove();
		}
	}
	
	// remove 
	@Override
	public void remove(Person person) {
		Iterator<Person> it = pList.iterator();
		while (it.hasNext()) {
		    Person p = it.next();
		    if (p == person) {
				it.remove();
		    }
		}
	}
	
	// get (by name)
	public Person get(String name) {
		Person person = null;
		for (Person p : pList) {
			if (p != null && p.getName().equals(name)) {
				person = p;
				break;
			}
		}
		return person;
	}

	// replace
	public void replace(String name, Person person) {
		int index = this.pList.indexOf(get(name));
		this.pList.set(index, person);
	}

	// size
	@Override
	public int size() {
		return this.pList.size();
	}
	
	// iterator
	@Override
	public Iterator<Person> iterator() {
		return this.pList.iterator();
	}

}
