package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationTest {

    @Test
    void simulationRunsCorrectly() {
        //given
        String[] inputs = {"f", "b", "r", "l", "f", "f"};
        List<MoveDirection> directions = OptionsParser.parse(inputs);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        //when
        RectangularMap rectangularMap = new RectangularMap(10,10);
        Simulation simulation = new Simulation(positions, directions, rectangularMap);
        simulation.run(rectangularMap);

        //then
        List<Animal> animals = simulation.getAnimals();
        assertTrue(simulation.getAnimals().get(0).isAt((new Vector2d(3,3))));
        assertTrue(simulation.getAnimals().get(1).isAt((new Vector2d(2,3))));
    }

}
