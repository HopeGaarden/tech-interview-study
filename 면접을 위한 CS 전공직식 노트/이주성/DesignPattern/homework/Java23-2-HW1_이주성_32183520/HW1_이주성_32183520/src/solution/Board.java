package solution;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Integer> spots;
    private int size;

    // Board(size: int)
    public Board(int size) {
        this.size = size;
        spots = new ArrayList<>();

        for (int i = 1; i <= Math.pow(size, 2); i++) {
            // System.out.println("i = " + i);
            spots.add(i);
        }
    }

    // Board(spots: List<Integer>)
    public Board(List<Integer> spots) {
        this.spots = spots;
        this.size = (int) Math.sqrt(spots.size());
    }

    // size(): int
    public int size() {
        return size;
    }


    // valueAt(index: int): int
    public int valueAt(int index) {
        return spots.get(index);
    }

    // valueAt(indices: List<Integer>): List<Integer>
    public List<Integer> valueAt(List<Integer> indices) {
        List<Integer> values = new ArrayList<>();

        for (int index : indices) {
            values.add(spots.get(index));
        }

        return values;
    }
}
