package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.Map;

abstract class AbstractWorldMap implements WorldMap {

    protected final Map<Vector2d, WorldElement> worldElements;
    protected final Vector2d DOWNCORNER = new Vector2d(0, 0);
    protected Vector2d UPCORNER;
    protected final MapVisualizer mapVisualizer;

    protected AbstractWorldMap(Map<Vector2d, WorldElement> worldElements) {
        this.worldElements = worldElements;
        this.mapVisualizer = new MapVisualizer(this);
    }

    public boolean place(Animal animal) {
        if(UPCORNER.follows(animal.getPosition()) && DOWNCORNER.precedes(animal.getPosition())) {
            worldElements.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public void move(Animal animal, MoveDirection direction) {
        if (worldElements.containsKey(animal.getPosition())) {
            var oldPosition = animal.getPosition();
            animal.move(direction,this);
            if (!oldPosition.equals(animal.getPosition())) {
                worldElements.remove(oldPosition);
                worldElements.put(animal.getPosition(), animal);
            }
        }
    }

    public boolean isOccupied(Vector2d position) {
        return worldElements.containsKey(position);
    }

    public WorldElement objectAt(Vector2d position) {
        return worldElements.getOrDefault(position, null);
    }

    public boolean canMoveTo(Vector2d position) {
        return UPCORNER.follows(position) && DOWNCORNER.precedes(position);
    }

    public String toString() {
        return mapVisualizer.draw(DOWNCORNER, UPCORNER);
    }

}
