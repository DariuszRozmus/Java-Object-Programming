package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public class RectangularMap extends AbstractWorldMap {

    private final Map<Vector2d, Animal> animals;
    private final Vector2d DOWNCORNER = new Vector2d(0, 0);
    private final Vector2d UPCORNER;
    private final MapVisualizer mapVisualizer;


    public RectangularMap(Vector2d upcorner) {
        super(new HashMap<>(), u, Vector2d upcorner, MapVisualizer mapVisualizer);


    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return UPCORNER.follows(position) && DOWNCORNER.precedes(position);
    }



//    private void removeAnimal(Animal animal, Vector2d position) {
//        List<Animal> animalList = animals.get(position);
//        if(animalList != null) {
//            animalList.remove(animal);
//            if(animalList.isEmpty()) {
//                animals.remove(animal.getPosition());
//            }
//        }
//    }
//
//    private void addAnimal(Animal animal) {
//        animals.computeIfAbsent(animal.getPosition(), x -> new ArrayList<>()).add(animal);
//    }





}
