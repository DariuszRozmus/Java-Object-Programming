package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrassFieldTest {

    @Test
    public void getElements() {
        var grassField = new GrassField(10);
        var positions = List.of(new Vector2d(0, 0), new Vector2d(3, 3), new Vector2d(4, 4));
        var parser = new OptionsParser();
        String[] input = {"f", "b", "f", "b"};

        var moveDirections = parser.parse(input);
        var simulation = new Simulation(positions, moveDirections, grassField, new ConsoleMapDisplay());
        simulation.run();

        var elements = grassField.getElements();

        assertEquals(13, elements.size());
    }
}
