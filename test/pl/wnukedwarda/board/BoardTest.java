package pl.wnukedwarda.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.wnukedwarda.IllegalMoveException;
import pl.wnukedwarda.ship.WarShip;
import pl.wnukedwarda.ship.shipTypes.Submarine;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private Field field;
    private WarShip ship;

    @BeforeEach
    void setUp() throws IllegalMoveException {
        board = new Board();
        field = board.getField(0,0);
    }

    @Test
    void testShouldBoardFill() {
        boolean result = board.fieldIsEmpty(board.getBoard());
        assertEquals(result,true);
    }

    @Test
    void testShouldAddWarShip() throws Exception {
        board.addShip(0,0, new Submarine());
        assertEquals(State.SHIP, field.getState());
    }

    @Test
    void testShouldNotBeAbleToAddFiveWarships() throws IllegalMoveException {
        board.addShip(3,3, new Submarine());
        board.addShip(2,1, new Submarine());
        board.addShip(7,7, new Submarine());
        board.addShip(9,9, new Submarine());

        IllegalMoveException exception = assertThrows(
                IllegalMoveException.class,
                () -> board.addShip(0,0, new Submarine()));

        assertEquals("You have all submarines set!",exception.getMessage());
    }
}