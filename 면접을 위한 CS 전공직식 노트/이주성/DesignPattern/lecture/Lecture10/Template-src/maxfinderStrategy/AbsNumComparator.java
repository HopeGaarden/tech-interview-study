package maxfinderStrategy;

public class AbsNumComparator implements Comparator {

	@Override
	public boolean isLesser(double a, double b) {
		return Math.abs(a) < Math.abs(b);
	}

}
