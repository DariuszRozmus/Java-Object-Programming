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
            String[] moves = moveField.getText().split(" ");
            List<MoveDirection> directions = parser.parse(moves);
            Simulation simulation = new Simulation(positions, directions, worldMap, consoleMapDisplay);
            new Thread(simulation).start();
        });
    }
    public void drawMap(){
        mapGrid.setHeight(500);
        mapGrid.setWidth(500);
        GraphicsContext graphics = mapGrid.getGraphicsContext2D();
        graphics.setFill(Color.WHITE);
        graphics.setStroke(Color.BLACK);
        graphics.setLineWidth(2.0);
        graphics.fillRect(0, 0, mapGrid.getWidth(), mapGrid.getHeight());
        Boundary boundary = worldMap.getCurrentBoundary();
        for (int x = 0; x < mapGrid.getWidth() + 1; x += 20) {
            graphics.strokeLine(x + 10, 0, x + 10, mapGrid.getHeight());  // BORDER_OFFSET = BORDER_WIDTH / 2
        }
        for (int y = 0; y < mapGrid.getHeight() + 1; y += 20) {
            graphics.strokeLine(0, y + 10, mapGrid.getWidth(), y + 10);  // BORDER_OFFSET = BORDER_WIDTH / 2
        }
        Collection<WorldElement> worldElements= worldMap.getElements();
        for (WorldElement worldElement : worldElements){
            graphics.strokeText(worldElement.toString(),
                    worldElement.getPosition().getX() * 20 + 15,
                    mapGrid.getHeight() - worldElement.getPosition().getY() * 20 - 10,
                    10);
        }
//        graphics.setTextAlign(TextAlignment.CENTER);
//        graphics.setTextBaseline(VPos.CENTER);
//        graphics.setFont(new Font("Arial", size));
//        graphics.setFill(black);
    }
    public void showMoves(String text){
        moveInfoLabel.setText(text);
    }
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
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
