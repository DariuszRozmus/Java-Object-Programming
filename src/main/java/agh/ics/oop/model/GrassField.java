package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.Map;

public class GrassField implements WorldMap{

    private int grassCount;
    private final Map<Vector2d, Animal> animals;
    private final Vector2d DOWNCORNER = new Vector2d(0, 0);
    private final Vector2d UPCORNER = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final MapVisualizer mapVisualizer;

    public GrassField(int grassCount, Map<Vector2d, Animal> animals, MapVisualizer mapVisualizer) {
        this.grassCount = grassCount;
        this.animals = animals;
        this.mapVisualizer = mapVisualizer;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }
}
