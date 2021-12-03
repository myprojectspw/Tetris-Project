package api.windows;

import api.settings.TetrisSettings;
import api.controllers.MainWindowButtons;
import api.settings.TetrisUtils;

public class MainWindow {
    // Frame
    public static void FrameMainMenu(TetrisSettings tetrisSettings) {
        // Prepare window
        TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());

        // Add components
        tetrisSettings.getFramesAtributes().mainWindowImage(tetrisSettings.getRoot(), tetrisSettings.getPrimaryStage());
        tetrisSettings.getFramesAtributes().mainWindowLabelMain(tetrisSettings.getRoot());
        tetrisSettings.getRoot().getChildren()
                .addAll(tetrisSettings.getMainBoard());

        // Add controllers
        MainWindowButtons.ButtonActionNewGame(tetrisSettings);
        MainWindowButtons.ButtonActionHighScores(tetrisSettings);
        MainWindowButtons.ButtonActionExit(tetrisSettings);

        // Show scene
        TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), tetrisSettings.getScene());
    }
}
