package pl.wnukedwarda;

import pl.wnukedwarda.board.Board;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();

        board.fillBoard();
        board.printBoard();
        System.out.println();
        board.printBoard();

    }
}
