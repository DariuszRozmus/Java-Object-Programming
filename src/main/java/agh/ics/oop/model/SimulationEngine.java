package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

    public void runAsyncThreadPool() throws InterruptedException {
//        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(Simulation simulation : simulationList){
            executorService.submit(new Thread(simulation));
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }

    public void awaitSimulationsEnd () throws InterruptedException {
        for (Thread thread : simulationThreads){
            thread.join();
        }
    }
}
