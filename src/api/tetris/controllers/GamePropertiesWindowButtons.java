package api.tetris.controllers;

import api.tetris.settings.TetrisSettings;
import api.tetris.windows.GamePropertiesWindow;
import api.tetris.windows.MainWindow;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import api.tetris.settings.TetrisUtils;

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
        // Create button
        Button cancelButton = tetrisSettings.getFramesAtributes().gamePropertiesWindowButtonCancel(tetrisSettings.getRoot());

        // Add logic
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                // If cancel go back to main menu
                tetrisSettings.setWrongName(0);
                MainWindow.FrameMainMenu(tetrisSettings);
            }
        };

        // Add event handler
        cancelButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}
