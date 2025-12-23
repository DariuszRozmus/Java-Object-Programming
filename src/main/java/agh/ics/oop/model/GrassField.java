package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;

//Tree set dobry pomysł, bo zachowuje kolejność, także można zawsze sprawdzić pierwszy i ostatni
// Collection<WorldElement> zamiast Collection<? extends WorldElement> bo to drugie może się ewoluować do WorldElement, GrassElement, Animal
public class GrassField extends AbstractWorldMap{

    private final Map<Vector2d, Grass> grasses;

    public GrassField(int grassCount) {
        super(new HashMap<Vector2d, Animal>());
        this.grasses = new HashMap<>();
        this.UPCORNER = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        int maxWidth = (int) (sqrt(10 * grassCount));
        int maxHeight = (int) (sqrt(10 * grassCount));
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(maxWidth, maxHeight, grassCount);
        for (Vector2d position : randomPositionGenerator) {
            grasses.put(position, new Grass(position));
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement animal = super.objectAt(position);
        return animal != null ? animal: grasses.get(position);
    }

    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)) {
            return true;
        }else {
            return grasses.get(position) != null;
        }
    }

    private Vector2d upperRight() {
        Vector2d corner = new Vector2d(0, 0);
        for (Vector2d position : grasses.keySet()) {
            corner =corner.upperRight(position);
        }
        for (Vector2d position : animals.keySet()) {
            corner =corner.upperRight(position);
        }
        return corner;
    }

    @Override
    public Collection<WorldElement> getElements() {
        var listOfAnimals = super.getElements();
        var listOfGrass = new ArrayList<>(grasses.values());
        return Stream.concat(listOfAnimals.stream(), listOfGrass.stream()).toList();
    }
    @Override
    public String toString() {
        return mapVisualizer.draw(DOWNCORNER, upperRight());
    }
}
