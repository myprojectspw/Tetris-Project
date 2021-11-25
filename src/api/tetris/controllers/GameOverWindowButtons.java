package api.tetris.controllers;

import api.tetris.TetrisSettings;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GameOverWindowButtons {
    // Controllers Buttons
    public static void ButtonOKReturn(TetrisSettings tetrisSettings) {
        // Create button
        Button okButton = tetrisSettings.getFramesAtributes().gameOverWindowButtonOK(tetrisSettings.getRoot());

        // Add logic
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                // Game ended, save player and back to main menu
                tetrisSettings.getAttributesFile().SaveProgress(tetrisSettings.getAllplayers());
                MainWindowButtons.FrameMainMenu(tetrisSettings);
            }
        };

        // Add event handler
        okButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}
