
package api.tetris.controllers;

import api.tetris.TetrisSettings;
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
    // FRAME
    public static void FrameMainMenu(TetrisSettings tetrisSettings) {

        // New window prepare
        TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().mainWindowImage(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().mainWindowLabelMain(tetrisSettings.getRoot());
        tetrisSettings.getRoot().getChildren()
                .addAll(tetrisSettings.getMainBoard());

        // Menu of buttons
        MainWindowButtons.ButtonActionNewGame(tetrisSettings);
        MainWindowButtons.ButtonActionHighScores(tetrisSettings);
        MainWindowButtons.ButtonActionExit(tetrisSettings);

        TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), tetrisSettings.getScene());
    }

    // BUTTON CONTROLERS
    public static void ButtonActionNewGame(TetrisSettings tetrisSettings) {

        Button newgame = tetrisSettings.getFramesAtributes().mainWindowButtonNewGame(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
                GamePropertiesWindowButtons.FrameDataOfPlayer(tetrisSettings);
            }
        };
        newgame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void ButtonActionHighScores(TetrisSettings tetrisSettings) {
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
                Tetriso.SetPlayersToTable(tetrisSettings.getAllplayers(), tetrisSettings.getData());
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

                        MainWindowButtons.FrameMainMenu(tetrisSettings);
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

    public static void ButtonActionExit(TetrisSettings tetrisSettings) {
        Button exit = tetrisSettings.getFramesAtributes().mainWindowButtonExit(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                System.exit(-1);
            }
        };
        exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}