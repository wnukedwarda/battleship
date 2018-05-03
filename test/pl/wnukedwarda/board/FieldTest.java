package pl.wnukedwarda.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    private Field field1;
    private Field field2;
    private static final State STATE1 = State.EMPTY;
    private static final State STATE2 = State.MISS;


    @BeforeEach
    void setUp() {
        field1 = new Field(3, 5, State.MISS);
        field2 = new Field(4, 6, State.EMPTY);
    }

    @Test
    void testSetShip() {
        field2.setShip(field1.getShip());
        assertEquals(field1.getShip(), field2.getShip());
        }
}
