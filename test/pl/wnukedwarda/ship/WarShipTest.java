package pl.wnukedwarda.ship;

import org.junit.jupiter.api.Test;
import pl.wnukedwarda.ship.shipTypes.BattleShip;
import pl.wnukedwarda.ship.shipTypes.Cruiser;

import static org.junit.jupiter.api.Assertions.*;

class WarShipTest {

    WarShip ship1 = new BattleShip();
    WarShip ship2 = new Cruiser();

    @Test
    void testHit() {
        ship1.hit(); ship1.hit();
        assertEquals(ship1.getHits(),2 );
    }

    @Test
    void testIsSunk() {
        ship1.hit();ship1.hit();ship1.hit();ship1.hit();
        boolean result = ship1.isSunk();

        assertTrue(result);
    }
}