package maxfinderStrategy;

public class MaxFinder {
	Comparator comparator;

	public MaxFinder(Comparator comparator) {
		this.comparator = comparator;
	}

	public double findMax(double[] numbers) {
		double max = numbers[0];
		for (int i=1; i<numbers.length; i++) {
			if (comparator.isLesser(max, numbers[i]))
				max = numbers[i];
		}
		return max;
	}

	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
	}
}
