package api.tetris.windows;

import api.tetris.TetrisSettings;
import api.tetris.controllers.GameOverWindowButtons;
import tetris.TetrisUtils;

public class GameOverWindow {
    // Frame
    public static void FrameEndScreen(TetrisSettings tetrisSettings) {
        // Prepare window
        TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
        tetrisSettings.getRoot().getChildren()
                .addAll(tetrisSettings.getGameOverBoard());

        // Add components
        tetrisSettings.getFramesAtributes().gameOverWindowImage(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gameOverWindowLabelMain(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gameOverWindowLabelScore(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gameOverWindowLabelScoreValue(tetrisSettings.getRoot(), tetrisSettings.getScore());

        // Add controllers
        GameOverWindowButtons.ButtonOKReturn(tetrisSettings);

        // Show scene
        TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), tetrisSettings.getScene());
    }
}
