package agh.ics.oop.model;

import agh.ics.oop.presenter.SimulationPresenter;

public class ConsoleMapDisplay implements MapChangeListener{

    private SimulationPresenter simulationPresenter;

    public ConsoleMapDisplay(){}

    public ConsoleMapDisplay(SimulationPresenter simulationPresenter){
        this.simulationPresenter = simulationPresenter;
    }

    @Override
    public synchronized void mapChanged(WorldMap map, String message) {
        System.out.println("Map " + map.getId());
        System.out.println("change: " + map.getIncrementCounter() + message);
        System.out.println(map);
        simulationPresenter.drawMap();
        simulationPresenter.showMoves(message);

    }

    @Override
    public void mapChanged(String message) {
        System.out.println("Map changed: "  + message);
    }
}
