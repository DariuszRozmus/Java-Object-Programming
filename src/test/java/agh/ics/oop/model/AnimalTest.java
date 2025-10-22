package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AnimalTest {

    @Test
    public void testMove() {
        //given
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        Animal animal4 = new Animal();
        Animal animal5 = new Animal();

        //when
        RectangularMap rectangularMap = new RectangularMap(10,10);
        animal1.move(MoveDirection.FORWARD, rectangularMap);
        animal2.move(MoveDirection.BACKWARD, rectangularMap);
        animal3.move(MoveDirection.LEFT, rectangularMap);
        animal4.move(MoveDirection.RIGHT, rectangularMap);
        animal5.isAt((new Vector2d(2,2)));

        //then
        assertTrue(animal1.isAt((new Vector2d(2,3))));
        assertEquals(MapDirection.NORTH, animal1.getDirection());

        assertTrue(animal2.isAt((new Vector2d(2,1))));
        assertEquals(MapDirection.NORTH, animal2.getDirection());

        assertEquals(MapDirection.WEST, animal3.getDirection());
        assertTrue(animal3.isAt((new Vector2d(2,2))));

        assertEquals(MapDirection.EAST, animal4.getDirection());
        assertTrue(animal4.isAt((new Vector2d(2,2))));

        assertEquals(MapDirection.NORTH, animal5.getDirection());
        assertTrue(animal5.isAt((new Vector2d(2,2))));



    }
}
