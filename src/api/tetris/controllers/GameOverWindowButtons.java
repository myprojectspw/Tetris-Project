package api.tetris.controllers;

import api.tetris.TetrisSettings;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import tetris.TetrisUtils;

public class GameOverWindowButtons {


    // Frame

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
