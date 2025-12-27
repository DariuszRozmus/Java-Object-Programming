package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    @Override
    public void mapChanged(WorldMap map, String message) {
        System.out.println("Map changed: " + message);
        System.out.println(map);
    }

    @Override
    public void mapChanged(String message) {
        System.out.println("Map changed: " + message);
    }
}
