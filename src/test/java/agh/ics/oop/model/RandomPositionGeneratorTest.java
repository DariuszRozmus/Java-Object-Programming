package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RandomPositionGeneratorTest {

    @Test
    public void count() {
        var random = new RandomPositionGenerator(0,0,0);
        var random2 = new RandomPositionGenerator(10,10,10);

        var grassPositions = new ArrayList<>();
        while (random2.iterator().hasNext()) {
            grassPositions.add(random2.iterator().next());
        }
        assertFalse(random.iterator().hasNext());
        assertEquals(grassPositions.size(), 10);
    }

}
