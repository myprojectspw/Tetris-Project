package tetris;

import java.util.LinkedList;

import api.settings.*;
import api.windows.MainWindow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import api.gui.FramesAttributes;

public class App extends Application {

    public TetrisSettings tetrisSettings;

    public static LinkedList<DataPlayer> allplayers = new LinkedList<>();

    @Override
    public void start(Stage stage) {
        SetMainPropertiesForGame(stage);

        MainWindow.FrameMainMenu(tetrisSettings);
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void SetMainPropertiesForGame(Stage stage) {
        tetrisSettings = new TetrisSettings();
        tetrisSettings.setRoot(new Pane());
        tetrisSettings.setMainBoard(new Canvas(400, 460));
        tetrisSettings.setHighScoresBoard(new Canvas(400, 520));
        tetrisSettings.setGameOverBoard(new Canvas(290, 280));
        tetrisSettings.setDataBoard(new Canvas(290, 280));
        tetrisSettings.setGameBoard(new Canvas(600, 600));
        tetrisSettings.setGraphicsContext(tetrisSettings.getGameBoard().getGraphicsContext2D());
        tetrisSettings.setPrimaryStage(stage);
        tetrisSettings.setScene(new Scene(tetrisSettings.getRoot()));
        tetrisSettings.setData(FXCollections.observableArrayList());
        tetrisSettings.setTable(new TableView<>());
        tetrisSettings.setFramesAtributes(new FramesAttributes());
        tetrisSettings.setAttributesFile(new InOutAttributes());
        tetrisSettings.setAttributesData(new DataAllPlayers());

        try {
            allplayers = (LinkedList<DataPlayer>) tetrisSettings.getAttributesFile().LoadProgress(allplayers);
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot found database of players, please reload application");
        }

        tetrisSettings.setAllplayers(allplayers);
    }




}
