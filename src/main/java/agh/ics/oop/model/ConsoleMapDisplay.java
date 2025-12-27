package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{

    public ConsoleMapDisplay(){
    }

    @Override
    public synchronized void mapChanged(WorldMap map, String message) {
        System.out.println("Map " + map.getId());
        System.out.println("change: " + map.getIncrementCounter() + message);
        System.out.println(map);
    }

    @Override
    public void mapChanged(String message) {
        System.out.println("Map changed: "  + message);
    }
}
