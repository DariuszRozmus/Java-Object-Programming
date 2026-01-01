package agh.ics.oop.presenter;

import agh.ics.oop.model.WorldMap;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SimulationPresenter {
    private WorldMap worldMap;

    @FXML
    private Label infoLabel;

    public SimulationPresenter(){}

    public void drawMap(){
        infoLabel.setText(worldMap.toString());
    }
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
}
