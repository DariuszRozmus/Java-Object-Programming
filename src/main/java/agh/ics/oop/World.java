package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.Simulation;
import agh.ics.oop.presenter.SimulationPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.model.MoveDirection.*;

public class World implements Runnable{

    private SimulationPresenter simulationPresenter;
    public World(SimulationPresenter simulationPresenter){
        this.simulationPresenter = simulationPresenter;

    }
    public World(){}

    public void run() {
        System.out.println("system wystartowal");
        OptionsParser parser = new OptionsParser();
//        System.out.println("system wystartowal");
//        int repeatCount = 400000;
        String[] arguments = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f"};

        List<MoveDirection> directions;
        try {
//            System.out.println("system wystartowal");
            directions = parser.parse(arguments);
//            System.out.println("system wystartowal");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
//            System.out.println("system wystartowal");
            System.exit(1);
            return;
        }
        WorldMap worldMap = new RectangularMap(new Vector2d(7,7));
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,3), new Vector2d(4,4));

        //        SimulationPresenter simulationPresenter = new SimulationPresenter();
//        simulationPresenter.setWorldMap(worldMap);
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay(simulationPresenter);
        simulationPresenter.setWorldMap(worldMap);
        Simulation simulation = new Simulation(positions, directions, worldMap, consoleMapDisplay);

//        simulation.run();
////        System.out.println("system");
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
