package agh.ics.oop.model;

import static agh.ics.oop.model.MapDirection.*;

public class Animal {

    private MapDirection direction;
    private Vector2d position;
    private final Vector2d UPCORNER = new Vector2d(4, 4);
    private final Vector2d DOWNCORNER = new Vector2d(0, 0);

    public Animal(Vector2d position) {
        this.position = position;
        this.direction = NORTH;
    }

    public Animal() {
        this(new Vector2d(2,2));
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void move(MoveDirection direction, MoveValidator validator) {
        switch (direction) {
            case FORWARD -> {
                Vector2d newPosition = position.add(this.direction.toUnitVector());
                this. position = validator.canMoveTo(newPosition) ? newPosition : position;
            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(this.direction.toUnitVector());
                this. position = validator.canMoveTo(newPosition) ? newPosition : position;
            }
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
        }
    }

    @Override
    public String toString() {
        return switch (direction) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
        };
    }
}
