package solution;

import java.util.ArrayList;
import java.util.List;

public class BoardShaper {
    Board board;

    // setBoard(Board board)
    public void setBoard(Board board) {
        this.board = board;
    }

    // List<Integer> row(int rowIndex)
    public List<Integer> row(int rowIndex) {
        List<Integer> rowValues = new ArrayList<>();

        int size = board.size();

        // rowIndex = 1 -> 0, 1, 2
        // rowIndex = 2 -> 3, 4, 5
        // rowIndex = 3 -> 6, 7, 8

        // 방법 1)
//        for (int i = (rowIndex - 1) * size; i < rowIndex * size; i++) {
//            rowValues.add(board.valueAt(i));
//        }
//        return rowValues;

        // 방법 2)
        List<Integer> rows = new ArrayList<>();
        for (int i = (rowIndex - 1) * size; i < rowIndex * size; i++) {
            rows.add(i);
        }

        return board.valueAt(rows);
    }

    // List<Integer> column(int columnIndex)
    public List<Integer> column(int columnIndex) {
        List<Integer> columnValues = new ArrayList<>();

        int size = board.size();

        // columnIndex = 1 -> 0, 3, 6
        // columnIndex = 2 -> 1, 4, 7
        // columnIndex = 3 -> 2, 5, 9

        // 방법 1)
//        for (int i = columnIndex - 1; i < size * size; i+=size) {
//            columnValues.add(board.valueAt(i));
//        }
//
//        return columnValues;

        // 방법 2)
        List<Integer> cols = new ArrayList<>();
        for (int i = columnIndex - 1; i < size * size; i+=size) {
            cols.add(i);
        }

        return board.valueAt(cols);
    }

    // List<Integer> diagonal()
    public List<Integer> diagonal() {
        List<Integer> diagonal = new ArrayList<>();

        int size = board.size();

        for (int i = 0; i < size * size; i += size + 1) {
            diagonal.add(board.valueAt(i));
        }
        return diagonal;
    }

    // Board transpose()
    public Board transpose() {
        List<Integer> tt = new ArrayList<>();
        int size = board.size();

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size * size; j += size) {
//                System.out.println("j = " + board.valueAt(j));
                tt.add(board.valueAt(j));
            }
        }

        return new Board(tt);
    }
}
