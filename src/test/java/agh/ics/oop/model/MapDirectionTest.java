package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {

    //given
    static final MapDirection NORTH = MapDirection.NORTH;
    static final MapDirection EAST = MapDirection.EAST;
    static final MapDirection SOUTH = MapDirection.SOUTH;
    static final MapDirection WEST = MapDirection.WEST;


    @Test
    //when then
    public void testNext() {
        assertEquals(NORTH, WEST.next());
        assertEquals(EAST, NORTH.next());
        assertEquals(SOUTH, EAST.next());
        assertEquals(WEST, SOUTH.next());
    }

    @Test
    //when then
    public void testPrevious() {
        assertEquals(NORTH, EAST.previous());
        assertEquals(EAST, SOUTH.previous());
        assertEquals(SOUTH, WEST.previous());
        assertEquals(WEST, NORTH.previous());
    }
}
