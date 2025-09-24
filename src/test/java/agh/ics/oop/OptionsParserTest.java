package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void testParseOptions() {

        //given
        String s1 = new String("a");
        String s2 = new String("b");
        String s3 = new String("f");
        String s4 = new String("r");
        String s5 = new String("");
        String s6 = new String(" ");
        String s7 = new String("l");

        String[] moves = new String[] {s1, s2, s3, s4, s5, s6, s7};

        OptionsParser parser = new OptionsParser();

        List<MoveDirection> moveDirections = List.of(MoveDirection.BACKWARD, MoveDirection.FORWARD,
                MoveDirection.RIGHT, MoveDirection.LEFT);

        //when
        List<MoveDirection> result = parser.parse(moves);

        //then
        assertIterableEquals(moveDirections, result);
    }

    @Test
    public void testParseCorrectDirections() {

        //given
        String s1 = new String("b");
        String s2 = new String("l");
        String s3 = new String("f");
        String s4 = new String("r");


        String[] moves = new String[] {s1, s2, s3, s4};

        OptionsParser parser = new OptionsParser();

        List<MoveDirection> moveDirections = List.of(MoveDirection.BACKWARD, MoveDirection.LEFT,
                MoveDirection.FORWARD, MoveDirection.RIGHT);

        //when
        List<MoveDirection> result = parser.parse(moves);

        //then
        assertIterableEquals(moveDirections, result);
    }

    @Test
    public void testParseIncorrectDirections() {

        //given
        String s1 = new String("");
        String s2 = new String(" ");
        String s3 = new String("'");
        String s4 = new String(";");


        String[] moves = new String[] {s1, s2, s3, s4};

        OptionsParser parser = new OptionsParser();

        List<MoveDirection> moveDirections = List.of();

        //when
        List<MoveDirection> result = parser.parse(moves);

        //then
        assertIterableEquals(moveDirections, result);
    }
}
