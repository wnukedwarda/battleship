package pl.wnukedwarda.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wnukedwarda.IllegalMoveException;
import pl.wnukedwarda.ship.Orientation;
import pl.wnukedwarda.ship.shipTypes.BattleShip;
import pl.wnukedwarda.ship.shipTypes.Destroyer;
import pl.wnukedwarda.ship.shipTypes.Submarine;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private Field field;

    @BeforeEach
    void setUp() {
        board = new Board();
        field = board.getField(0,0);
    }

    @Test
    void testShouldBoardFill() {
        boolean result = board.fieldIsEmpty(board.getBoard());
        assertEquals(result,true);
    }

    @Test
    void testShouldAddShip() throws IllegalMoveException {
        board.addShip(0,0, new Submarine());
        assertEquals(State.SHIP, field.getState());
    }

    @Test
    void testShouldAddDestroyerOnFields() throws IllegalMoveException {
        board.addShip(1,0, new Destroyer(Orientation.HORIZONTAL));
        assertEquals(State.SHIP, field.getState());
    }

    @Test
    void testShouldNotBeAbleToAddFiveWarships() throws IllegalMoveException {
        board.addShip(1,1, new Submarine());
        board.addShip(3,3, new Submarine());
        board.addShip(5,5, new Submarine());
        board.addShip(7,7, new Submarine());

        IllegalMoveException exception = assertThrows(
                IllegalMoveException.class,
                () -> board.addShip(8,8, new Submarine()));

    }

    @Test
    void testShouldNotBeAbleToAddTwoBattleShips() throws IllegalMoveException {
        board.addShip(0,0,new BattleShip(Orientation.HORIZONTAL));

        IllegalMoveException exception = assertThrows(
                IllegalMoveException.class, ()
                        -> board.addShip(6,0,new BattleShip(Orientation.HORIZONTAL)));

        assertEquals("You have all ship set!", exception.getMessage());
    }
}