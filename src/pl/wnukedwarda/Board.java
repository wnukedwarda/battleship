package pl.wnukedwarda;

public class Board {

    public static final int BOARD_SIZE = 10;
    private Field[][] fields = new Field[BOARD_SIZE][BOARD_SIZE];

    public Board(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                fields[i][j] = new Field(i,j, State.EMPTY);
            }
        }
    }

    public Field[][] getBoard() {
        return fields;
    }

    public void fillBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                fields[i][j].setState(getRandomShip(Math.random()));
            }
        }
    }

    private void printLetters() {
        System.out.print("   ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((char) ('A' + i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public void printBoard() {
        printLetters();
        for (int i = 0; i < BOARD_SIZE; i++) {
            int numberToPrint = i + 1;
            if (numberToPrint < BOARD_SIZE) {
                System.out.print(' ');
            }
            System.out.print(numberToPrint + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                char shipValue = fields[i][j].stateToChar();
                System.out.print(shipValue + " ");
            }
            System.out.println();
        }
    }


    private State getRandomShip(double random) {
        if (random < 0.2) return State.HIT;
        else if (random > 0.8) return State.EMPTY;
        else return State.MISS;
    }
}

