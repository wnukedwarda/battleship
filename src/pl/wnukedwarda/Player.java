package pl.wnukedwarda;

import pl.wnukedwarda.board.Board;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Player {

    Board myBoard = new Board();
    Scanner sc = new Scanner(System.in);
    boolean tryAgain;

    public void play(Board board) {
        System.out.println("Opponent's Board");
        board.printBoard();
        System.out.println("Your move!");
        do {
            try {
                String move = sc.nextLine();
                move = move.toUpperCase();
                int y = move.charAt(0) - 'A';
                int x = move.charAt(1) - '0';

                board.shoot(x, y);
                board.printBoard();
                tryAgain = false;
            } catch (IllegalMoveException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Try Again!");
                tryAgain = true;
            }
        } while (tryAgain);
    }

}
