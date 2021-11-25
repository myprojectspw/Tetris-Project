package api.tetris.controllers;

import api.tetris.TetrisSettings;
import api.tetris.windows.GamePropertiesWindow;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import tetris.TetrisUtils;
import tetris.Tetriso;

public class GamePropertiesWindowButtons {

    // CONTROL BUTTONS
    public static void ButtonActionOKToGame(TetrisSettings tetrisSettings) {
        // Create button
        Button playButton = tetrisSettings.getFramesAtributes().gamePropertiesWindowButtonPlay(tetrisSettings.getRoot());

        // Add logic
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                // If player name is wrong
                if (tetrisSettings.getNameOfPlayer().isEmpty() || tetrisSettings.getNameOfPlayer().matches("^.*[^a-zA-Z].*$")) {
                    // Load same window
                    tetrisSettings.setWrongName(1);
                    TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
                    GamePropertiesWindow.FrameDataOfPlayer(tetrisSettings);
                } else {
                    // Start game
                    tetrisSettings.setWrongName(0);
                    tetrisSettings.getRoot().getChildren()
                            .clear();
                    tetrisSettings.getPrimaryStage().close();
                    TetrisGame tetris = new TetrisGame(tetrisSettings);

                    Scene scene = new Scene(tetris.Create());
                    tetris.start(scene);
                    TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), scene);
                }
            }
        };

        // Add event handler
        playButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void ButtonCancelToBack(TetrisSettings tetrisSettings) {
        Button Cancel = tetrisSettings.getFramesAtributes().gamePropertiesWindowButtonCancel(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                tetrisSettings.setWrongName(0);
                MainWindowButtons.FrameMainMenu(tetrisSettings);
            }
        };
        Cancel.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}
