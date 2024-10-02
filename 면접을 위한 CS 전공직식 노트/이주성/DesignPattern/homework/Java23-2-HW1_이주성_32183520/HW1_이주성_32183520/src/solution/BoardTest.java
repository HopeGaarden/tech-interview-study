package solution;

public class BoardTest {
    Board[] boards = {new Board(2), new Board(3), new Board(4), new Board(5)};
    IBoardDisplay presenter = new BoardDisplay();
    BoardShaper shaper = new BoardShaper();

    public BoardTest() {

        for (Board board : boards) {
            System.out.println("board [ " + board.size() + " ] start");
            // board display
            presenter.display(board);

            System.out.println();

            // set board in a shaper
            shaper.setBoard(board);

            // boardReturnsRow
            for (int index = 1; index <= board.size(); index++) {
                System.out.println("row#" + index + " " + shaper.row(index));
            }

            System.out.println();

            // boardReturnsColumn
            for (int index = 1; index <= board.size(); index++) {
                System.out.println("column#" + index + " " + shaper.column(index));
            }

            System.out.println();

            // boardReturnsDiagonal
            System.out.println("diagonal " + shaper.diagonal());

            System.out.println();

            // boardReturnsTranspose
            Board transpose = shaper.transpose();
            System.out.println("transpose");
            presenter.display(transpose);

            System.out.println("============end==========");
            System.out.println();
        }
    }
}
