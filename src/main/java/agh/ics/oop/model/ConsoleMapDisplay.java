package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int counter = 0;

    public ConsoleMapDisplay(){
    }

    @Override
    public void mapChanged(WorldMap map, String message) {
        counter += 1;
        System.out.println("Map changed: " + counter + message);
        System.out.println(map);
    }

    @Override
    public void mapChanged(String message) {
        counter += 1;
        System.out.println("Map changed: " + counter+ message);
    }
}
