package maxfinderStrategy;

public class MaxFinderMainTest {

	public MaxFinderMainTest() {
		double[] numbers = {-20.5, 87.3, 12.3, 2.5, -5.7, 65.4, -97};
		MaxFinder finder = new MaxFinder(new NaturalNumComparator());
		double max = finder.findMax(numbers);
		System.out.println("NaturalNumMaxFinder max: " + max);

		finder.setComparator(new AbsNumComparator());
		max = finder.findMax(numbers);
		System.out.println("AbsNumMaxFinder max: " + max);
	}

}
