package agh.ics.oop.model;

public class IncorrectPositionException extends RuntimeException {
    public IncorrectPositionException(Vector2d position) {
        super(position + "is not correct");
    }
}
