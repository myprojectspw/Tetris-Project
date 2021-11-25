package api.tetris.controllers;

import api.tetris.TetrisSettings;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GameOverWindowButtons {
    // Controllers Buttons
    public static void ButtonOKReturn(TetrisSettings tetrisSettings) {
        Button OK = tetrisSettings.getFramesAtributes().gameOverWindowButtonOK(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                tetrisSettings.getAttributesFile().SaveProgress(tetrisSettings.getAllplayers());
                MainWindowButtons.FrameMainMenu(tetrisSettings);
            }
        };
        OK.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}
