package solution;

public class BoardDisplay implements IBoardDisplay {
    @Override
    public void display(Board board) {
        int size = board.size();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int index = row * size + col;
                if (col == size - 1) {
                    System.out.print(board.valueAt(index));
                } else {
                    System.out.print(board.valueAt(index) +" | ");
                }
            }
            System.out.println();
        }
    }
}
