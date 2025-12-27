package agh.ics.oop.model;

public interface MapChangeListener {

    void mapChanged(WorldMap map, String message);

    void mapChanged(String message);
}
