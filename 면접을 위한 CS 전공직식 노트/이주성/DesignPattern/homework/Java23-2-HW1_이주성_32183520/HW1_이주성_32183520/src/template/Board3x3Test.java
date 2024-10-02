package template;

public class Board3x3Test {

    public Board3x3Test() {
        Board3x3 board = new Board3x3();
        // Board display
        board.display();
        // FirstRow
        System.out.println("row#1 " + board.firstRow());
        // SecondRow
        System.out.println("row#2 " + board.secondRow());
        // ThirdRow
        System.out.println("row#3 " + board.thirdRow());
        // FirstColumn
        System.out.println("column#1 " + board.firstColumn());
        // SecondColumn
        System.out.println("column#2 " + board.secondColumn());
        // ThirdColumn
        System.out.println("column#3 " + board.thirdColumn());
        // Diagonal
        System.out.println("diagonal " + board.diagonal());
        // Transpose
        System.out.println("transpose=");
        Board3x3 transpose = board.transpose();
        transpose.display();
    }
}
