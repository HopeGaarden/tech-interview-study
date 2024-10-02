package model;

import java.util.Iterator;
import java.util.List;

public class PersonList implements Iterable<Person> {
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
	
	// add 
	public void add(Person person) {
		pList.add(person);
	}
	
	// remove all 
	public void removeAll() {
		Iterator<Person> it = pList.iterator();
		while (it.hasNext()) {
		    it.next();
			it.remove();
		}
	}
	
	// remove 
	public void remove(Person other) {
		Iterator<Person> it = pList.iterator();
		while (it.hasNext()) {
		    Person p = it.next();
		    if (p == other) {
				it.remove();
		    }
		}
	}
	
	// get 
	public Person get(Person other) {
		Iterator<Person> it = pList.iterator();
		while (it.hasNext()) {
			Person p = it.next();
		    if (p == other) {
		    	return p;
		    }
		}
		return null;
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
	public void replace(String name, Person other) {
		int index = pList.indexOf(get(name));
		pList.set(index, other);
	}

	// size
	public int size() {
		return pList.size();
	}
	
	@Override
	public Iterator<Person> iterator() {
		return pList.iterator();
	}

}
