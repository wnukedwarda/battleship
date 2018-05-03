package pl.wnukedwarda.ship.shipTypes;

import pl.wnukedwarda.ship.Orientation;
import pl.wnukedwarda.ship.WarShip;

public class Cruiser extends WarShip {

    public Cruiser(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 3;
    }
}
