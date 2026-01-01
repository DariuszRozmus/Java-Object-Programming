package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SimulationApp extends Application {

    private WorldMap worldMap;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.show();
        FXMLLoader loader = new FXMLLoader(); // zainicjowanie wczytywania FXML

        // wczytanie zasobu z katalogu resources (uniwersalny sposób)
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));

        // Wczytanie FXML, konwersja FXML -> obiekty w Javie
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();
        configureStage(primaryStage,viewRoot);

        System.out.println("system wystartowal");
        OptionsParser parser = new OptionsParser();
        String[] arguments = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f"};
        List<MoveDirection> directions;
        try {
            directions = parser.parse(arguments);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return;
        }
//        WorldMap worldMap = new RectangularMap(new Vector2d(5,5));
        WorldMap worldMap = new GrassField(17);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,3), new Vector2d(4,4));
        presenter.setWorldMap(worldMap);
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay(presenter);
        Simulation simulation = new Simulation(positions, directions, worldMap, consoleMapDisplay);
        new Thread(simulation).start();
        simulation.showAnimals();
        simulation.showMoves();

        System.out.println("system zakonczyl dzialanie");
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        // stworzenie sceny (panelu do wyświetlania wraz zawartością z FXML)
        var scene = new Scene(viewRoot);

        // ustawienie sceny w oknie
        primaryStage.setScene(scene);

        // konfiguracja okna
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
        // primaryStage.show();
    }

    public void setWorldMap(WorldMap worldMap){
        this.worldMap = worldMap;
    }
}
