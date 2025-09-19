package agh.ics.oop.model;

public class Animal {

    private MapDirection direction;
    private Vector2d position;

    public Animal(Vector2d position) {
        this.position = position;
        this.direction = MapDirection.NORTH;
    }

    public Animal() {
        this(new Vector2d(2,2));
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
    
    @Override
    public String toString() {
        return String.format("Animal[%s,%s]",direction,position);
    }
}
