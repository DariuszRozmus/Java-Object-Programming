package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.fxml.FXML;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.Collection;
import java.util.List;

import static java.awt.Color.black;
//import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.size;

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
    @FXML
    private Canvas mapGrid = new Canvas();
//    private Boundary boundary;

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
