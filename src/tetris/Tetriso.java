package tetris;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import api.tetris.TetrisSettings;
import api.tetris.controllers.TetrisGame;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import api.tetris.gui.FramesAttributes;

public class Tetriso extends Application {

    public TetrisSettings tetrisSettings;

    public static LinkedList<DataPlayer> allplayers = new LinkedList<>();

    @Override
    public void start(Stage stage) {
        SetMainPropertiesForGame(stage);

        FrameMainMenu(tetrisSettings);

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
    // --------------------------------------------------------------------------------
    // Frames
    // --------------------------------------------------------------------------------

    public static void FrameMainMenu(TetrisSettings tetrisSettings) {

        // New window prepare
        TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().mainWindowImage(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().mainWindowLabelMain(tetrisSettings.getRoot());
        tetrisSettings.getRoot().getChildren()
            .addAll(tetrisSettings.getMainBoard());

        // Menu
        ButtonAcctionNewGame(tetrisSettings);
        FrameHighScores(tetrisSettings);
        ButtonAcctionEnd(tetrisSettings);

        TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), tetrisSettings.getScene());
    }


    public static void FrameHighScores(TetrisSettings tetrisSettings) {
        Button HighScore = tetrisSettings.getFramesAtributes().mainWindowButtonHighScores(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            @SuppressWarnings("unchecked")
            public void handle(MouseEvent e) {
                TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
                Scene scene = new Scene(new Group());

                Label label = new Label("Scores of All Players");
                label.setFont(new Font("Arial", 20));

                tetrisSettings.getTable().setEditable(true);

                @SuppressWarnings("rawtypes")
                TableColumn RankOfPlayers = tetrisSettings.getAttributesData().TableColumnRankOfPlayersProperties();
                @SuppressWarnings("rawtypes")
                TableColumn NameOfPlayers = tetrisSettings.getAttributesData().TableColumnNameOfPlayersProperties();
                @SuppressWarnings("rawtypes")
                TableColumn ScoreOfPlayers = tetrisSettings.getAttributesData().TableColumnScoreOfPlayersProperties();
                // Tetriso
                SetPlayersToTable(tetrisSettings.getAllplayers(), tetrisSettings.getData());
                tetrisSettings.getTable().setItems(tetrisSettings.getData());
                tetrisSettings.getTable().getColumns()
                     .addAll(RankOfPlayers, NameOfPlayers, ScoreOfPlayers);

                Button OKToMenu = tetrisSettings.getFramesAtributes().highScoresWindowButtonOK(tetrisSettings.getRoot());

                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent e) {
                        tetrisSettings.getTable().getColumns()
                             .clear();
                        tetrisSettings.getData().clear();

                        FrameMainMenu(tetrisSettings);
                    }
                };
                OKToMenu.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

                VBox vbox = new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10, 0, 0, 10));
                vbox.getChildren()
                    .addAll(label, tetrisSettings.getTable());

                ((Group) scene.getRoot()).getChildren()
                                         .addAll(vbox, OKToMenu);

                TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), scene);
            }
        };
        HighScore.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void FrameDataOfPlayer(TetrisSettings tetrisSettings) {
        TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
        tetrisSettings.getRoot().getChildren()
            .addAll(tetrisSettings.getDataBoard());
        tetrisSettings.getFramesAtributes().gamePropertiesWindowImage(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gamePropertiesWindowPlayerNameLabel(tetrisSettings.getRoot());
        if (tetrisSettings.getWrongName() == 1) {
            tetrisSettings.getFramesAtributes().gamePropertiesWindowWrongPlayerName(tetrisSettings.getRoot());
        }
        tetrisSettings.getFramesAtributes().gamePropertiesWindowChoseLevel(tetrisSettings.getRoot());
        TextField NamePlayer = tetrisSettings.getFramesAtributes().gamePropertiesWindowTextField();

        tetrisSettings.setNameOfPlayer("");
        NamePlayer.textProperty()
                  .addListener((observable, oldValue, newValue) -> {
                      tetrisSettings.setNameOfPlayer(newValue);
                  });

        tetrisSettings.setDifficultyLevel(1);
        ToggleGroup group = new ToggleGroup();

        RadioButton Easy = tetrisSettings.getFramesAtributes().gamePropertiesWindowEasy();
        Easy.setToggleGroup(group);

        RadioButton Medium = tetrisSettings.getFramesAtributes().gamePropertiesWindowMedium();
        Medium.setToggleGroup(group);

        RadioButton Hard = tetrisSettings.getFramesAtributes().gamePropertiesWindowHard();
        Hard.setToggleGroup(group);

        group.selectedToggleProperty()
             .addListener(new ChangeListener<Toggle>() {

                 @Override
                 public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                     if (group.getSelectedToggle() != null) {
                         tetrisSettings.setDifficultyLevel(Integer.parseInt(group.getSelectedToggle()
                                                                 .getUserData()
                                                                 .toString()));
                     }
                 }
             });
        ButtonAcctionOKToGame(tetrisSettings);

        ButtonCancelToBack(tetrisSettings);
        tetrisSettings.getRoot().getChildren()
            .addAll(NamePlayer, Easy, Medium, Hard);
        TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), tetrisSettings.getScene());
    }

    public static void FrameEndScreen(TetrisSettings tetrisSettings) {
        TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
        tetrisSettings.getRoot().getChildren()
            .addAll(tetrisSettings.getGameOverBoard());
        tetrisSettings.getFramesAtributes().gameOverWindowImage(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gameOverWindowLabelMain(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gameOverWindowLabelScore(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gameOverWindowLabelScoreValue(tetrisSettings.getRoot(), tetrisSettings.getScore());
        ButtonOKReturn(tetrisSettings);
        TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), tetrisSettings.getScene());
    }
    // --------------------------------------------------------------------------------
    // ButtonActions
    // --------------------------------------------------------------------------------

    public static void ButtonAcctionNewGame(TetrisSettings tetrisSettings) {
//        SetNewValues();
        Button newgame = tetrisSettings.getFramesAtributes().mainWindowButtonNewGame(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
                FrameDataOfPlayer(tetrisSettings);
            }
        };
        newgame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void ButtonAcctionEnd(TetrisSettings tetrisSettings) {
        Button Exit = tetrisSettings.getFramesAtributes().mainWindowButtonExit(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                System.exit(-1);
            }
        };
        Exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void ButtonAcctionOKToGame(TetrisSettings tetrisSettings) {
        // Tetriso.i te funkcje

        Button Play = tetrisSettings.getFramesAtributes().gamePropertiesWindowButtonPlay(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                if (tetrisSettings.getNameOfPlayer().isEmpty() || tetrisSettings.getNameOfPlayer().matches("^.*[^a-zA-Z].*$")) {
                    tetrisSettings.setWrongName(1);
                    TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());

                    FrameDataOfPlayer(tetrisSettings);
                } else {
                    tetrisSettings.setWrongName(0);
                    tetrisSettings.getRoot().getChildren()
                        .clear();
                    tetrisSettings.getPrimaryStage().close();
                    TetrisGame tetrs = new TetrisGame(tetrisSettings);
                    tetrs.SetNewValues();
                    // Tetriso.TetrisGame(scene);
                    Scene scene = new Scene(tetrs.Create());
                    tetrs.TetrisGame(scene);
                    TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), scene);
                }
            }
        };
        Play.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void ButtonCancelToBack(TetrisSettings tetrisSettings) {
        Button Cancel = tetrisSettings.getFramesAtributes().gamePropertiesWindowButtonCancel(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                tetrisSettings.setWrongName(0);
                FrameMainMenu(tetrisSettings);
            }
        };
        Cancel.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void ButtonOKReturn(TetrisSettings tetrisSettings) {
        Button OK = tetrisSettings.getFramesAtributes().gameOverWindowButtonOK(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                tetrisSettings.getAttributesFile().SaveProgress(tetrisSettings.getAllplayers());

                FrameMainMenu(tetrisSettings);
            }
        };
        OK.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
    // --------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------

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
