package pl.wnukedwarda.ship;

import pl.wnukedwarda.board.Field;

public interface Ship {

    int getDecksCount();
    void hit();
    boolean isSunk();
    void setOnField(Field field, int deckNumber);
    Orientation getOrientation();
}
