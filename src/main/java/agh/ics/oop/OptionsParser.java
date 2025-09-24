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
        for(int i = 0; i < inputs.length; i++){
            switch (inputs[i]){
                case "f" -> moves.add(MoveDirection.FORWARD);
                case "b" -> moves.add(MoveDirection.BACKWARD);
                case "l" -> moves.add(MoveDirection.LEFT);
                case "r" -> moves.add(MoveDirection.RIGHT);
            }
        }
        return moves;
    }
}
