package pl.wnukedwarda.board;

import pl.wnukedwarda.IllegalMoveException;
import pl.wnukedwarda.ship.WarShip;
import pl.wnukedwarda.ship.shipTypes.Submarine;

public class Board {

    public static final int BOARD_SIZE = 10;
    private Field[][] fields = new Field[BOARD_SIZE][BOARD_SIZE];
    private int shipsCount;
    private int submarineCount;

    public Board() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                fields[i][j] = new Field(i, j, State.EMPTY);
            }
        }
    }

    public Field getField(int x, int y){
        return fields[x][y];
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

    public void addShip(int x, int y, WarShip warShip) throws IllegalMoveException {
        if(submarineCount >=4){
            throw new IllegalMoveException("You have all submarines set!");
        }
        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            throw new IllegalMoveException("Ship set outside board!");
        }
        warShip.setOnField(fields[x][y],0);
        shipsCount++;
        submarineCount++;
    }

    public static boolean fieldIsEmpty(Field[][] fields) {
        boolean result = true;
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                result = result && isTrue(fields[i][j].getState());
            }
        }

        return result;
    }

    private static boolean isTrue(State state) {
        if (State.EMPTY.equals(State.EMPTY)) return true;
        else return false;
    }

    public int getShipsCount() {
        return shipsCount;
    }
}

