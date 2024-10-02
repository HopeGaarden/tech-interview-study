package controller;

import java.util.ArrayList;
import java.util.List;

import model.Person;
import view.ImageView;
import view.TextView;

public class App {
    public static void main(String[] args) {
        //new PersonController();

        // create a model
		List<Person> pList = new ArrayList<>();
		// create views
		ImageView imageView = new ImageView();
		TextView textView = new TextView();		
		// create a controller
		PersonListController controller = new PersonListController(pList, imageView, textView);
		Person[] people = {
				new Person(3000, "Dooly"),
				new Person(30, "Ddochi"),
				new Person(25, "kildong"),
				new Person(20000, "Douner"),
				new Person(3, "HeeDong")
		};
		for (Person person : people) {
			controller.add(person);
		}
    }
}
