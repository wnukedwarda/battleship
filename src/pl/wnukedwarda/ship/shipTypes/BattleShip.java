package pl.wnukedwarda.ship.shipTypes;

import pl.wnukedwarda.ship.Orientation;
import pl.wnukedwarda.ship.WarShip;

public class BattleShip extends WarShip {

    public BattleShip(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 4;
    }
}
