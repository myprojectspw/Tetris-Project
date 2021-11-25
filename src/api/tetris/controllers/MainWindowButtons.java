
package api.tetris.controllers;

import api.tetris.TetrisSettings;
import api.tetris.windows.GamePropertiesWindow;
import api.tetris.windows.MainWindow;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tetris.TetrisUtils;
import tetris.Tetriso;

public class MainWindowButtons {
    // Controllers Buttons
    public static void ButtonActionNewGame(TetrisSettings tetrisSettings) {
        // Create button
        Button newgameButton = tetrisSettings.getFramesAtributes().mainWindowButtonNewGame(tetrisSettings.getRoot());

        // Add logic
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                // Choose game properties
                TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
                GamePropertiesWindow.FrameDataOfPlayer(tetrisSettings);
            }
        };

        // Add event handler
        newgameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void ButtonActionHighScores(TetrisSettings tetrisSettings) {
        // Create button
        Button highScoreButton = tetrisSettings.getFramesAtributes().mainWindowButtonHighScores(tetrisSettings.getRoot());

        // Add logic
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            @SuppressWarnings("unchecked")
            public void handle(MouseEvent e) {
                // Show data table with players scores
                TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
                Scene scene = createDatatable(tetrisSettings);
                TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), scene);
            }
        };

        // Add event handler
        highScoreButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void ButtonActionExit(TetrisSettings tetrisSettings) {
        // Create button
        Button exitButton = tetrisSettings.getFramesAtributes().mainWindowButtonExit(tetrisSettings.getRoot());

        // Add logic
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                // exit program
                System.exit(-1);
            }
        };

        // Add event handler
        exitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    // Utils
    public static Scene createDatatable(TetrisSettings tetrisSettings) {
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
        Tetriso.SetPlayersToTable(tetrisSettings.getAllplayers(), tetrisSettings.getData());
        tetrisSettings.getTable().setItems(tetrisSettings.getData());
        tetrisSettings.getTable().getColumns()
                .addAll(RankOfPlayers, NameOfPlayers, ScoreOfPlayers);

        Button okBackToMenuButton = createBackToMainMenu(tetrisSettings);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren()
                .addAll(label, tetrisSettings.getTable());

        ((Group) scene.getRoot()).getChildren()
                .addAll(vbox, okBackToMenuButton);

        return scene;
    }

    public static Button createBackToMainMenu(TetrisSettings tetrisSettings) {
        // Create button
        Button okBackToMenuButton = tetrisSettings.getFramesAtributes().highScoresWindowButtonOK(tetrisSettings.getRoot());

        // Add logic
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                tetrisSettings.getTable().getColumns()
                        .clear();
                tetrisSettings.getData().clear();

                MainWindow.FrameMainMenu(tetrisSettings);
            }
        };

        // Add event handler
        okBackToMenuButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        return okBackToMenuButton;
    }
}