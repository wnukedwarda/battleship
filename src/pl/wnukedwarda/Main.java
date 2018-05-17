package pl.wnukedwarda;

import pl.wnukedwarda.board.Board;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        board.fillBoard();

        while (board.getShipsCount()>0){

            Scanner sc = new Scanner(System.in);

            board.printBoard();
            String move = sc.nextLine();
            move = move.toUpperCase();
            int y = move.charAt(0) - 'A';
            int x = move.charAt(1) - '0';

            try {
                board.shoot(x, y);
            }catch (IllegalMoveException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Game over!");
    }
}
