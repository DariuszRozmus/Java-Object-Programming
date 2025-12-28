package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.model.MoveDirection.*;

public class World {

    public static void main(String[] args) {
        System.out.println("system wystartowal");
        OptionsParser parser = new OptionsParser();

        int repeatCount = 400000;
        String[] baseArguments = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f"};
        String[] arguments = new String[baseArguments.length * repeatCount];

        for (int i = 0; i < repeatCount; i++) {
            System.arraycopy(baseArguments, 0, arguments, i * baseArguments.length, baseArguments.length);
        }

        List<MoveDirection> directions;
        try {
            directions = parser.parse(arguments);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return;
        }
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,3), new Vector2d(4,4));
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
//        Simulation simulationGrassField = new Simulation(positions, directions, new GrassField(10), consoleMapDisplay);
//        Simulation simulationRectangularMap = new Simulation(positions, directions, new RectangularMap(new Vector2d(10,10)), consoleMapDisplay);
        List<Simulation> mapList = new ArrayList<>();
        for (int i = 0; i<6; i++){
            Simulation simulation1 = new Simulation(positions, directions, new GrassField(10), consoleMapDisplay);
            Simulation simulation2 = new Simulation(positions, directions, new RectangularMap(new Vector2d(10,10)), consoleMapDisplay);
            mapList.add(simulation1);
            mapList.add(simulation2);
        }
        SimulationEngine engine = new SimulationEngine(mapList);
        try {
            engine.runAsyncThreadPool();
            engine.awaitSimulationsEnd();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

//        simulation.run();
//        simulation.showAnimals();
//        simulation.showMoves();

        System.out.println("system zakonczyl dzialanie");
    }

    public static void run(List<MoveDirection> directions){

        for(MoveDirection direction : directions){
            switch (direction){
                case FORWARD -> System.out.println("zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("zwierzak idzie do tylu");
                case LEFT -> System.out.println("zwierzak skreca w lewo");
                case RIGHT -> System.out.println("zwierzak skreca w prawo");
            }
        };

    }
}
