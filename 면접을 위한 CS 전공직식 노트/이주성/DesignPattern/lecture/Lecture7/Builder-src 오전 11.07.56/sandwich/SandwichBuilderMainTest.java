package sandwich;

import java.util.Arrays;

public class SandwichBuilderMainTest {
	public SandwichBuilderMainTest() {
		// classic way to create an object
		// 전통적인 자바 빈 방식
		Sandwich s = new Sandwich();
		s.setName("Steak And Cheese Sandwich");
		s.setBread("Oatmeal Bread");
		s.setPatty("Beef Steak");
		s.setPrice(10500);
		s.setOthers(Arrays.asList("Cheese", "Tomato", "Onion"));
		System.out.println(s);
		
		// builder pattern
		SandwichBuilder sb = new SandwichBuilder.Builder()
				.name("Chicken Bacon Avocado Sandwich")
				.bread("Whole Grain Bread")
				.patty("Chicken")
				.price(9500)
				.others(Arrays.asList("Bacon","Avocado"))
				.build();
		System.out.println(sb);
	}
}