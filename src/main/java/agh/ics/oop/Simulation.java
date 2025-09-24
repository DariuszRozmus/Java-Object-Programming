package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.Animal;
import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<MoveDirection> moves;
    private List<Vector2d> positions;
    private List<Animal> animals = new ArrayList<>();

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves) {
        this.moves = moves;
        this.positions = positions;
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
            animals.add(new Animal((Vector2d) position));
        }
        for (int i=0; i < moves.size(); i++) {
            animals.get(i%positions.size()).move(moves.get(i));
            System.out.println("Zwierze"+i+":"+animals.get(i%positions.size()));
        }
    }
}
