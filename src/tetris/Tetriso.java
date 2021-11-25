package tetris;

import java.util.LinkedList;

import api.tetris.TetrisSettings;
import api.tetris.controllers.MainWindowButtons;
import api.tetris.controllers.TetrisGame;
import api.tetris.windows.MainWindow;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import api.tetris.gui.FramesAttributes;

public class Tetriso extends Application {

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

    public static Player player;

    public static void SetPlayersToTable(LinkedList<DataPlayer> allplayers, ObservableList<Player> data) {
        int size = allplayers.size();
        DataPlayer pom = new DataPlayer();
        for (int i = 0; i < size; i++) {
            pom = allplayers.get(i);
            player = new Player(String.valueOf(i + 1), pom.Name_Of_Player, String.valueOf(pom.Score));
            data.add(player);
        }
    }


}
