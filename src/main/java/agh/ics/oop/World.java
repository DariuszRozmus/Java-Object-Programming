package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    public static void main(String[] args) {
        System.out.println("system wystartowal");
        OptionsParser parser = new OptionsParser(args);
        MoveDirection[] directions = parser.parse();
        run(directions);
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
