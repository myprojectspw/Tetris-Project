package api.tetris.gui;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import tetris.TetrisUtils;

public class FramesAttributes {
    // mainWindow(Label)Name VIOLET
    // gamePropertiesWindow BLUE
    // highScoresWindow
    // gameOverWindow YELLOW
    // gameHighScoresWindow GREEN

    public FramesAttributes() {
    }
    // Labels  =========================================================================================================

    public void mainWindowLabelMain(Pane root) {
        TetrisUtils.prepareLabel(root, "TETRIS", "Arial", 100.0D, 30.0D, 35.0D);
    }

    public void gameOverWindowLabelMain(Pane root) {
        TetrisUtils.prepareLabel(root, "GAME OVER", "Arial", 40.0D, 20.0D, 50.0D);
    }

    public void gameOverWindowLabelScore(Pane root) {
        TetrisUtils.prepareLabel(root, "Your Score", "Arial", 40.0D, 40.0D, 100.0D);
    }

    public void gameOverWindowLabelScoreValue(Pane root, double score) {
        TetrisUtils.prepareLabelScore(root, score, "Arial", 40.0D, 120.0D, 150.0D);
    }

    public void gamePropertiesWindowChoseLevel(Pane root) {
        TetrisUtils.prepareLabel(root, "Set difficulty level of game", "Arial", 20.0D, 40.0D, 110.0D);
    }

    public void gamePropertiesWindowPlayerNameLabel(Pane root) {
        TetrisUtils.prepareLabel(root, "Set your player name", "Arial", 20.0D, 50.0D, 25.0D);
    }

    public void gamePropertiesWindowWrongPlayerName(Pane root) {
        TetrisUtils.prepareLabel(root, "Wrong Name Of Player", "Arial", 20.0D, 50.0D, 5.0D);
    }
    public void gameHighScoresWindowMainLabel(Pane root) {
        TetrisUtils.prepareLabel(root, "Scores of All Players", "Arial", 20.0D, 50.0D, 5.0D);
    }

    // BUTTONS =========================================================================================================

    public Button gamePropertiesWindowButtonCancel(Pane root) {
        return TetrisUtils.prepareButton(root, "Cancel", 100.0D, 50.0D, 160.0D, 220.0D);
    }

    public Button gamePropertiesWindowButtonPlay(Pane root) {
        return TetrisUtils.prepareButton(root, "Play", 100.0D, 50.0D, 40.0D, 220.0D);
    }

    public Button highScoresWindowButtonOK(Pane root) {
        return TetrisUtils.prepareButton(root, "OK", 90.0D, 70.0D, 150.0D, 440.0D);
    }

    public Button gameOverWindowButtonOK(Pane root) {
        return TetrisUtils.prepareButton(root, "OK", 90.0D, 70.0D, 100.0D, 200.0D);
    }

    public Button mainWindowButtonNewGame(Pane root) {
        return TetrisUtils.prepareButton(root, "New Game", 150.0D, 70.0D, 135.0D, 190.0D);
    }

    public Button mainWindowButtonHighScores(Pane root) {
        return TetrisUtils.prepareButton(root, "HighScores", 150.0D, 70.0D, 135.0D, 270.0D);
    }

    public Button mainWindowButtonExit(Pane root) {
        return TetrisUtils.prepareButton(root, "Exit", 150.0D, 70.0D, 135.0D, 350.0D);
    }

    // Images  =========================================================================================================

    public void mainWindowImage(Pane root) {
        TetrisUtils.prepareImage(root, "api/tetris/images/tetris2.jpg", 500.0D, 420.0D);
    }

    public void gamePropertiesWindowImage(Pane root) {
        TetrisUtils.prepareImage(root, "api/tetris/images/data.jpg", 300.0D, 300.0D);
    }

    public void gameOverWindowImage(Pane root) {
        TetrisUtils.prepareImage(root, "api/tetris/images/scores.jpg", 300.0D, 300.0D);
    }

    public void gameHighScoresWindowImage(Pane root) {
        TetrisUtils.prepareImage(root, "api/tetris/images/HighScores.jpg", 550.0D, 410.0D);
    }

    // Radiobutton ====================================================================================================

    public RadioButton gamePropertiesWindowEasy() {
        return TetrisUtils.prepareRadiobutton("Easy", 120.0D, 150.0D, "1", true);
    }

    public RadioButton gamePropertiesWindowMedium() {
        return TetrisUtils.prepareRadiobutton("Medium", 120.0D, 170.0D, "2", false);
    }

    public RadioButton gamePropertiesWindowHard() {
        return TetrisUtils.prepareRadiobutton("Hard", 120.0D, 190.0D, "3", false);
    }

    // TextField =======================================================================================================

    public TextField gamePropertiesWindowTextField() {
        TextField TextFieldForNameOfPlayer = new TextField();
        TextFieldForNameOfPlayer.setTranslateX(80.0D);
        TextFieldForNameOfPlayer.setTranslateY(70.0D);
        return TextFieldForNameOfPlayer;
    }

}