package agh.ics.oop.presenter;

import agh.ics.oop.Simulation;
import agh.ics.oop.model.WorldMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SimulationPresenter {
    private WorldMap worldMap;

    @FXML
    private Label infoLabel;

    @FXML
    private Label moveInfoLabel;

    @FXML
    private Button startButton;

    private Simulation simulation;

    public SimulationPresenter(){
    }

    @FXML
    void initialize(){
        startButton.setOnAction(actionEvent -> {
            new Thread(simulation).start();
            startButton.setDisable(true);
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
    public void setSimulation(Simulation simulation){
        this.simulation = simulation;
    }
}
