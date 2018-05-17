package pl.wnukedwarda;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player();
        Player player2 = new Player();
        player1.myBoard.fillBoard();
        player2.myBoard.fillBoard();

        do {
            System.out.println("============ Player 1 move ============");
            System.out.println();
            player1.play(player2.myBoard);
            if (player2.myBoard.getShipsCount() == 0) {
                System.out.println("Player 1 Win! Congratulations!");
                break;
            }

            System.out.println("============ Player 2 move ============");
            player2.play(player1.myBoard);
            if (player1.myBoard.getShipsCount() == 0) {
                System.out.println("Player 2 Win! Congratulations");
                break;
            }
        } while (player1.myBoard.getShipsCount() == 0
                || player2.myBoard.getShipsCount() == 0);

        System.out.println("The End!");
    }
}
