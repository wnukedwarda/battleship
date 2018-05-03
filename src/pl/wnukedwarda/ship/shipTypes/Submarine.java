package pl.wnukedwarda.ship.shipTypes;

import pl.wnukedwarda.ship.WarShip;

public class Submarine extends WarShip {
    @Override
    public int getDecksCount() {
        return 1;
    }
}
