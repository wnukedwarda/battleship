package pl.wnukedwarda.ship.shipTypes;

import pl.wnukedwarda.ship.WarShip;

public class BattleShip extends WarShip {
    @Override
    public int getDecksCount() {
        return 4;
    }
}
