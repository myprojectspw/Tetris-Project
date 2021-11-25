package api.tetris.windows;

import api.tetris.TetrisSettings;
import api.tetris.controllers.GameOverWindowButtons;
import api.tetris.controllers.HighScoresWindowButtons;
import javafx.scene.control.TableColumn;
import tetris.TetrisUtils;
import tetris.Tetriso;

public class HighScoresWindow {
    public static void FrameHighScores(TetrisSettings tetrisSettings) {
        // Prepare window
        TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
        tetrisSettings.getRoot().getChildren()
                .addAll(tetrisSettings.getHighScoresBoard());

        // Add components
        tetrisSettings.getFramesAtributes().gameHighScoresWindowImage(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gameHighScoresWindowMainLabel(tetrisSettings.getRoot());

        // Add data table
        createDatatable(tetrisSettings);

        // Add controllers
        HighScoresWindowButtons.createBackToMainMenu(tetrisSettings);

        // Show scene
        TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), tetrisSettings.getScene());

    }

    public static void createDatatable(TetrisSettings tetrisSettings) {
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

        tetrisSettings.getRoot().getChildren().add(tetrisSettings.getTable());
    }
}
