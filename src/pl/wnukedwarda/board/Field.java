package pl.wnukedwarda.board;

import pl.wnukedwarda.ship.Ship;

public class Field {

    private final int x;
    private final int y;
    private State state;
    private Ship ship;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public State getState() {
        return state;
    }

    public Ship getShip() {
        return ship;
    }

    public Field(int x, int y, State state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public char stateToChar() {
        char token;

        switch (state) {
            case SHIP:
            case EMPTY:
                token = ' ';
                break;

            case HIT:
                token = 'o';
                break;

            case SUNK:
                token = 'x';
                break;

            case MISS:
                token = '!';
                break;

            default:
                token = '?';
        }
        return token;
    }

    public void setState(State state) {
        this.state = state;
    }
}
