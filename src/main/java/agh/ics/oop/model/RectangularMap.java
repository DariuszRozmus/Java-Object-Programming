package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(Vector2d upcorner) {
        super(new HashMap<Vector2d, Animal>());
        this.UPCORNER = upcorner;
    }
}
