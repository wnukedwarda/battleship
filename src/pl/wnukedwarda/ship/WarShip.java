package pl.wnukedwarda.ship;

import pl.wnukedwarda.board.Field;
import pl.wnukedwarda.board.State;

public abstract class WarShip implements Ship {

    private Orientation orientation;
    private int hits;
    private Field[] occupied;

    public Orientation getOrientation() { return orientation; }

    public int getHits() { return hits; }

    public Field[] getOccupied() { return occupied; }

    public WarShip(Orientation orientation){
        this.orientation = orientation;
        occupied =  new Field[getDecksCount()];
    }

    @Override
    public boolean isSunk() {
        return hits == getDecksCount();
    }

    public void setOnField(Field field, int deckNumber){
        field.setShip(this);
        field.setState(State.SHIP);
        occupied[deckNumber] = field;
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
