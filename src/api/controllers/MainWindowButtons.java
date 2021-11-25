
package api.controllers;

import api.settings.TetrisSettings;
import api.windows.GamePropertiesWindow;
import api.windows.HighScoresWindow;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import api.settings.TetrisUtils;

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
                HighScoresWindow.FrameHighScores(tetrisSettings);
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
}