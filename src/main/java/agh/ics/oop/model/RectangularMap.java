package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {

    private HashMap<Vector2d, Animal> animals;
    private Vector2d upcorner;

    public RectangularMap(int width, int height) {
        this.animals = new HashMap<>();
        this.upcorner = new Vector2d(width, height);
    }

    @Override
    public boolean place(Animal animal) {
        if (!animals.containsKey(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsKey(animal.getPosition())) {
            var oldPosition = animal.getPosition();
            animal.move(direction);
            animals.remove(oldPosition);
            animals.put(animal.getPosition(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }
}
