package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.Map;

abstract class AbstractWorldMap implements WorldMap {

    private final Map<Vector2d, Animal> animals;
    private final Vector2d DOWNCORNER = new Vector2d(0, 0);
    private Vector2d UPCORNER;
    private final MapVisualizer mapVisualizer;

    protected AbstractWorldMap(Map<Vector2d, Animal> animals, Vector2d upcorner, MapVisualizer mapVisualizer) {
        this.animals = animals;
        this.UPCORNER = upcorner;
        this.mapVisualizer = mapVisualizer;
    }

    public boolean place(Animal animal) {
        if(UPCORNER.follows(animal.getPosition()) && DOWNCORNER.precedes(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsKey(animal.getPosition())) {
            var oldPosition = animal.getPosition();
            animal.move(direction,this);
            if (!oldPosition.equals(animal.getPosition())) {
                animals.remove(oldPosition);
                animals.put(animal.getPosition(), animal);
            }
        }
    }

    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    public Animal objectAt(Vector2d position) {
        return isOccupied(position) ? animals.get(position) : null;
    }

    public abstract boolean canMoveTo(Vector2d position);

    public String toString() {
        return mapVisualizer.draw(DOWNCORNER, UPCORNER);
    }

}
