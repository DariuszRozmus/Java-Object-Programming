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
//    private MapVisualizer mapVisualizer;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap worldMap) {
        this.moves = moves;
        this.positions = positions;
        this.worldMap = worldMap;
//        this.mapVisualizer = new MapVisualizer(worldMap);
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

    public void run(MoveValidator validator){
        for(Vector2d position: positions) {
            Animal animal = new Animal(position);
            animals.add(animal);
//            boolean bool = this.worldMap.place(new Animal((Vector2d) positions));
            worldMap.place(animal);
        }
        for (int i=0; i < moves.size(); i++) {
//            animals.get(i%positions.size()).move(moves.get(i),this.worldMap);
            worldMap.move(animals.get(i % animals.size()), moves.get(i));
            System.out.println("Zwierze nr "+i % animals.size()+":"+moves.get(i));
            System.out.println(worldMap);
        }
    }
}
