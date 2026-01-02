package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.ConsoleMapDisplay;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class SimulationPresenter {
    private WorldMap worldMap;

    @FXML
    private Label infoLabel;

    @FXML
    private Label moveInfoLabel;

    @FXML
    private Button startButton;

    @FXML
    private TextField moveField;

    private Simulation simulation;
    private OptionsParser parser;
    private List<Vector2d> positions;
    private ConsoleMapDisplay consoleMapDisplay;

    public SimulationPresenter(){
    }

    @FXML
    void initialize(){
        startButton.setOnAction(actionEvent -> {
            startButton.setDisable(true);
            String[] moves = this.getMoves();
            List<MoveDirection> directions = parser.parse(moves);
            Simulation simulation = new Simulation(positions, directions, worldMap, consoleMapDisplay);
            new Thread(simulation).start();
        });
    }
    public void drawMap(){
        infoLabel.setText(worldMap.toString());
    }
    public void showMoves(String text){
        moveInfoLabel.setText(text);
    }
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
//    public void setAll(Simulation simulation){
//        this.simulation = simulation;
//    }
    public void setConsoleMapDisplay(ConsoleMapDisplay consoleMapDisplay){
        this.consoleMapDisplay = consoleMapDisplay;
    }
    public void setPositions(List<Vector2d> positions){
        this.positions = positions;
    }

    private String[] getMoves(){
        String str = moveField.getText();
        return str.split(" ");
    }
}
