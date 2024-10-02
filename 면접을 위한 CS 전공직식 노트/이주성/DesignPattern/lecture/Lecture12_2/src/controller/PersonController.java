package controller;

import java.util.Arrays;
import java.util.List;

import model.PersonList;
import model.Person;
import view.LabelView;
import view.ButtonView;

public class PersonController  {

	public PersonController() {
		List<Person> people = Arrays.asList(new Person[] {
				new Person(3000, "Dooly"),
				new Person(30, "Ddochi"),
				new Person(25, "kildong"),
				new Person(20000, "Douner"),
				new Person(3, "HeeDong")
		});
		// create a model
		PersonList model = new PersonList(people);

		// create views
		LabelView listView = new LabelView(model);
		listView.display();
		ButtonView cardView = new ButtonView(model);
		cardView.display();
	}
}
