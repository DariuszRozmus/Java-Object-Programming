package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

abstract class AbstractWorldMap implements WorldMap {

    protected final Map<Vector2d, Animal> animals;
    protected final Vector2d DOWNCORNER = new Vector2d(0, 0);
    protected Vector2d UPCORNER;
    protected final MapVisualizer mapVisualizer;
    protected List<MapChangeListener> eventListeners = new ArrayList<>();
    protected final UUID uuid = UUID.randomUUID();
    protected int changeCounter = 0;

    protected AbstractWorldMap(Map<Vector2d, Animal> animals) {
        this.animals = animals;
        this.mapVisualizer = new MapVisualizer(this);
    }

    public void place(Animal animal) throws IncorrectPositionException{
        if(UPCORNER.follows(animal.getPosition()) && DOWNCORNER.precedes(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
        }
        else {
            throw new IncorrectPositionException(animal.getPosition());
        }
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

    public WorldElement objectAt(Vector2d position) {
        return animals.getOrDefault(position, null);
    }

    public boolean canMoveTo(Vector2d position) {
        return UPCORNER.follows(position) && DOWNCORNER.precedes(position);
    }

    public Collection<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

    public Boundary getCurrentBoundary() {
        return new Boundary(DOWNCORNER, UPCORNER);
    }

    public void addMapChangeListener(MapChangeListener listener) {
        eventListeners.add(listener);
    }

    public void removeMapChangeListener(MapChangeListener listener) {
        eventListeners.remove(listener);
    }

    @Override
    public UUID getId() {
        return uuid;
    }

    public int getIncrementCounter(){
        changeCounter ++;
        return changeCounter;
    }

    public String toString() {
        return mapVisualizer.draw(getCurrentBoundary().lowerLeft(), getCurrentBoundary().upperRight());
    }

}
