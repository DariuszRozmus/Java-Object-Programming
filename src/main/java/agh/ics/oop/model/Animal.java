package agh.ics.oop.model;

public class Animal {

    private MapDirection direction;
    private Vector2d position;
    Vector2d UPCORNER = new Vector2d(4, 4);
    Vector2d DOWNCORNER = new Vector2d(0, 0);

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

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD-> {
                Vector2d newposition = this.position.add(this.direction.toUnitVector());
                if(UPCORNER.follows(newposition) && DOWNCORNER.precedes(newposition))
                    this.position = this.position.add(this.direction.toUnitVector());
                System.out.println(this.position);
            }
            case BACKWARD-> {
                Vector2d newposition = this.position.subtract(this.direction.toUnitVector());
                if(UPCORNER.follows(newposition) && DOWNCORNER.precedes(newposition))
                    this.position = this.position.subtract(this.direction.toUnitVector());
                System.out.println(this.position);
            }
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
        }
    }

    @Override
    public String toString() {
        return String.format("Animal[%s,%s]",direction,position);
    }
}
