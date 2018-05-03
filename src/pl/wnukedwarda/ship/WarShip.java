package pl.wnukedwarda.ship;

import pl.wnukedwarda.board.Field;
import pl.wnukedwarda.board.State;

public abstract class WarShip implements Ship {

    private Orientation orientation;
    private int hits;
    private Field[] occupied;

    public WarShip(){
        occupied =  new Field[getDecksCount()];
    }

    @Override
    public boolean isSunk() {
        return hits == getDecksCount();
    }

    @Override
    public void hit() {
        hits++;
        if(isSunk()){
            for (int i = 0; i < occupied.length; i++) {
                occupied[i].setState(State.SUNK);
            }
        }
    }
}
