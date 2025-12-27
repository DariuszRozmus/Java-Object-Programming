package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<MoveDirection> moves;
    private List<Vector2d> positions;
    private List<Animal> animals = new ArrayList<>();
    private WorldMap worldMap;
    private ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap worldMap) {
        this.moves = moves;
        this.positions = positions;
        this.worldMap = worldMap;
    }

    public void showAnimals(){
        for(Animal animal : animals){
            System.out.println(animal);
        }
    }
    public List<Animal> getAnimals(){
        return animals;
    }

    public void showMoves(){
        for(MoveDirection move : moves){
            System.out.println(move);
        }
    }

    public List<MoveDirection> getMoves(){
        return moves;
    }

    public void run(){
        for(Vector2d position: positions) {
            Animal animal = new Animal(position);
            try {
                worldMap.place(animal);
                animals.add(animal);
            } catch (IncorrectPositionException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i=0; i < moves.size(); i++) {
            worldMap.move(animals.get(i % animals.size()), moves.get(i));
            consoleMapDisplay.mapChanged(worldMap,
                    " Zwierze nr "+i % animals.size()+": "+moves.get(i)+" pozycja: "+animals.get(i%animals.size()).getPosition());
        }
    }
}
