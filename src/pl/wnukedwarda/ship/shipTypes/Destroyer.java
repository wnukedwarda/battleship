package pl.wnukedwarda.ship.shipTypes;

import pl.wnukedwarda.ship.Orientation;
import pl.wnukedwarda.ship.WarShip;

public class Destroyer extends WarShip {

    public Destroyer(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 2;
    }
}
