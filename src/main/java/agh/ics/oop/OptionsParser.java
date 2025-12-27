package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

//    private static String[] inputs;

    public OptionsParser(){
//        this.inputs = args;
    }

    public static List<MoveDirection> parse(String[] inputs){

        List<MoveDirection> moves = new ArrayList<MoveDirection>();
        for(String input : inputs){
            switch (input){
                case "f" -> moves.add(MoveDirection.FORWARD);
                case "b" -> moves.add(MoveDirection.BACKWARD);
                case "l" -> moves.add(MoveDirection.LEFT);
                case "r" -> moves.add(MoveDirection.RIGHT);
                default -> {throw new IllegalArgumentException(
                            input + " is not legal move specification" );
                }
            }
        }
        return moves;
    }
}
