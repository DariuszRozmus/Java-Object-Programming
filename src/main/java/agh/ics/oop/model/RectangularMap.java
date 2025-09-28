package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap implements WorldMap {

    private final Map<Vector2d, List<Animal>> animals;
    private final Vector2d DOWNCORNER = new Vector2d(0, 0);
    private final Vector2d UPCORNER;
    private final MapVisualizer mapVisualizer;


    public RectangularMap(int width, int height) {
        this.animals = new HashMap<>();
        this.UPCORNER = new Vector2d(width-1, height-1);
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean place(Animal animal) {
        if(UPCORNER.follows(animal.getPosition()) && DOWNCORNER.precedes(animal.getPosition())) {
            animals.computeIfAbsent(animal.getPosition(), x -> new ArrayList<>()).add(animal);
            return true;
        }
        return false;
    }

    private void removeAnimal(Animal animal, Vector2d position) {
        List<Animal> animalList = animals.get(position);
        if(animalList != null) {
            animalList.remove(animal);
            if(animalList.isEmpty()) {
                animals.remove(animal.getPosition());
            }
        }
    }

    private void addAnimal(Animal animal) {
        animals.computeIfAbsent(animal.getPosition(), x -> new ArrayList<>()).add(animal);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsKey(animal.getPosition())) {
            var oldPosition = animal.getPosition();
            animal.move(direction);
            removeAnimal(animal, oldPosition);
            addAnimal(animal);
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
