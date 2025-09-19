package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class World {

    public static void main(String[] args) {
        System.out.println("system wystartowal");
        OptionsParser parser = new OptionsParser();
        MoveDirection[] directions = parser.parse(args);
        run(directions);
//        var vector2d = new Vector2d(1,2);
//        System.out.println(vector2d);

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);

        Vector2d position2 = new Vector2d(1,2);
        System.out.println(position2);

        Animal animal = new Animal();
        System.out.println(animal);
        System.out.println(position1.equals(position2));
        System.out.println("system zakonczyl dzialanie");
    }

    public static void run(MoveDirection[] directions){

        for(int i = 0; i < directions.length; i++ ){
            switch (directions[i]){
                case FORWARD -> System.out.println("zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("zwierzak idzie do tylu");
                case LEFT -> System.out.println("zwierzak skreca w lewo");
                case RIGHT -> System.out.println("zwierzak skreca w prawo");
            }
        };

    }
}
