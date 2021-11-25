package api.controllers;

import api.settings.TetrisSettings;
import api.windows.MainWindow;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HighScoresWindowButtons {
    // Controllers Buttons
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
