package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.Simulation;
import java.util.List;

import static agh.ics.oop.model.MoveDirection.*;

public class World {

    public static void main(String[] args) {
        System.out.println("system wystartowal");
        OptionsParser parser = new OptionsParser();
        List<MoveDirection> directions = parser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,3), new Vector2d(4,4));
        WorldMap Map = new GrassField(10);
        Simulation simulation = new Simulation(positions, directions, Map);
        simulation.run(Map);
        simulation.showAnimals();
        simulation.showMoves();

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
