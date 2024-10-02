package template;
import java.util.List;
import java.util.ArrayList;

public class Board3x3 {
    private List<Integer> spots; // 3 x 3 board

    public Board3x3() {
        this.spots = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            this.spots.add(i);
        }
    }

    // 리팩토링이 필요한 코드 시작
    // row

    public List<Integer> firstRow() {
        List<Integer> row = new ArrayList<Integer>();
        row.add(this.spots.get(0));
        row.add(this.spots.get(1));
        row.add(this.spots.get(2));
        return row;
    }

    public List<Integer> secondRow() {
        List<Integer> secondRow = new ArrayList<Integer>();
        secondRow.add(this.spots.get(3));
        secondRow.add(this.spots.get(4));
        secondRow.add(this.spots.get(5));
        return secondRow;
    }

    public List<Integer> thirdRow() {
        List<Integer> thirdRow = new ArrayList<Integer>();
        thirdRow.add(this.spots.get(6));
        thirdRow.add(this.spots.get(7));
        thirdRow.add(this.spots.get(8));
        return thirdRow;
    }
    
    public List<Integer> firstColumn() {
        List<Integer> row = new ArrayList<Integer>();
        row.add(this.spots.get(0));
        row.add(this.spots.get(3));
        row.add(this.spots.get(6));
        return row;
    }

    public List<Integer> secondColumn() {
        List<Integer> secondRow = new ArrayList<Integer>();
        secondRow.add(this.spots.get(1));
        secondRow.add(this.spots.get(4));
        secondRow.add(this.spots.get(7));
        return secondRow;
    }

    public List<Integer> thirdColumn() {
        List<Integer> thirdRow = new ArrayList<Integer>();
        thirdRow.add(this.spots.get(2));
        thirdRow.add(this.spots.get(5));
        thirdRow.add(this.spots.get(8));
        return thirdRow;
    }

    public List<Integer> diagonal() {
        List<Integer> diagonal = new ArrayList<Integer>();
        diagonal.add(this.spots.get(0));
        diagonal.add(this.spots.get(4));
        diagonal.add(this.spots.get(8));
        return diagonal;
    }

    public Board3x3 transpose() {
        Board3x3 transpose = new Board3x3();
        // Assigns the transpose of element A[j][i] to B[i][j]
        transpose.spots.set(0, this.spots.get(0));
        transpose.spots.set(1, this.spots.get(3));
        transpose.spots.set(2, this.spots.get(6));
        transpose.spots.set(3, this.spots.get(1));
        transpose.spots.set(4, this.spots.get(4));
        transpose.spots.set(5, this.spots.get(7));
        transpose.spots.set(6, this.spots.get(2));
        transpose.spots.set(7, this.spots.get(5));
        transpose.spots.set(8, this.spots.get(8));
        return transpose;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.spots.get(0) + " | " + this.spots.get(1) + " | " + this.spots.get(2) + "\n" + this.spots.get(3) + " | " + this.spots.get(4) + " | " + this.spots.get(5) + "\n" + this.spots.get(6) + " | " + this.spots.get(7) + " | " + this.spots.get(8);
    }
}
