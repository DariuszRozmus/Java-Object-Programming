package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
            System.out.println("Pozycja grass: "+position);
        }
    }
// Jeśli nadpisujemy metodę, to dobrze użyć super.metodaAbstractClassy
    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement animal = super.objectAt(position);
        return animal != null ? animal: grasses.get(position);
    }
    // TODO Nadpisać getElements (stworzyć XD)

//    @Override
//    public List<WorldElement> getElements() {
//
//    }
}
