package api.windows;

import api.settings.DataPlayer;
import api.settings.Player;
import api.settings.TetrisSettings;
import api.controllers.HighScoresWindowButtons;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import api.settings.TetrisUtils;

import java.util.LinkedList;

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
        SetPlayersToTable(tetrisSettings.getAllplayers(), tetrisSettings.getData());
        tetrisSettings.getTable().setItems(tetrisSettings.getData());
        tetrisSettings.getTable().getColumns()
                .addAll(RankOfPlayers, NameOfPlayers, ScoreOfPlayers);

        tetrisSettings.getRoot().getChildren().add(tetrisSettings.getTable());
    }

    public static Player player;

    public static void SetPlayersToTable(LinkedList<DataPlayer> allplayers, ObservableList<Player> data) {
        int size = allplayers.size();
        DataPlayer pom = new DataPlayer();
        for (int i = 0; i < size; i++) {
            pom = allplayers.get(i);
            player = new Player(String.valueOf(i + 1), pom.Name_Of_Player, String.valueOf(pom.Score));
            data.add(player);
        }
    }
}
