package pl.wnukedwarda.board;

import pl.wnukedwarda.IllegalMoveException;
import pl.wnukedwarda.ship.Orientation;
import pl.wnukedwarda.ship.Ship;
import pl.wnukedwarda.ship.WarShip;

public class Board {

    public static final int BOARD_SIZE = 10;
    public static final int SHIP_TYPES_COUNT = 4;

    private Field[][] fields = new Field[BOARD_SIZE][BOARD_SIZE];
    private int shipsCount;
    private int[] numberOfShipsByDeck = new int[SHIP_TYPES_COUNT];

    public Board() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                fields[i][j] = new Field(i, j, State.EMPTY);
            }
        }
    }

    public Field getField(int x, int y) {
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

    public void addShip(int x, int y, Ship ship) throws IllegalMoveException {

        int count = ship.getDecksCount();
        if (numberOfShipsByDeck[count - 1]
                == getTotalCountOfShips(count)) {
            throw new IllegalMoveException("You have all ship set!");
        }
        if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
            throw new IllegalMoveException("Ship set outside board!");
        }

        Field[] field = new Field[count];
        int xToSet = x, ytoSet = y;

        for (int i = 0; i < count; i++) {
            if(ship.getOrientation() == Orientation.HORIZONTAL){
                xToSet = x+1;
            }else {
                ytoSet = y+i;
            }
        }

        ship.setOnField(fields[x][y], 0);

        shipsCount++;
        numberOfShipsByDeck[count - 1]++;


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


    private int getTotalCountOfShips(int decksCount) {
        return SHIP_TYPES_COUNT - decksCount + 1;
    }
}

