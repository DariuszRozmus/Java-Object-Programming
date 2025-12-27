package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {

    private List<Simulation> simulationList;
    private List<Thread> simulationThreads = new ArrayList<>();

    public SimulationEngine(List<Simulation> simulationList){
        this.simulationList = simulationList;
    }

    public void runSync(){
        for(Simulation simulation : simulationList){
            simulation.run();
        }
    }

    public void runAsync(){
        for(Simulation simulation : simulationList){
            simulationThreads.add(new Thread(simulation));
        }
        for(Thread thread : simulationThreads){
           thread.start();
        }
    }

    public void awaitSimulationsEnd () throws InterruptedException {
        for (Thread thread : simulationThreads){
            thread.join();
        }
    }
}
