package api.tetris.gui;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import tetris.TetrisUtils;

public class FramesAttributes {

    public FramesAttributes() {
    }
    // Labels  =========================================================================================================

    public void mainWindowLabel(Pane root) {
        TetrisUtils.prepareLabel(root, "TETRIS", "Arial", 100.0D, 30.0D, 35.0D);
    }

    public void gameOverWindowLabel(Pane root) {
        TetrisUtils.prepareLabel(root, "GAME OVER", "Arial", 40.0D, 20.0D, 50.0D);
    }

    public void gameScoreWindowLabel(Pane root) {
        TetrisUtils.prepareLabel(root, "Your Score", "Arial", 40.0D, 40.0D, 100.0D);
    }

    public void gameScoreWindowLabelScore(Pane root, double score) {
        TetrisUtils.prepareLabelScore(root, score, "Arial", 40.0D, 120.0D, 150.0D);
    }

    public void gameChooseDifficultyWindowChoseLevel(Pane root) {
        TetrisUtils.prepareLabel(root, "Set difficulty level of game", "Arial", 20.0D, 40.0D, 110.0D);
    }

    public void gameChooseDifficultyWindowPlayerNameLabel(Pane root) {
        TetrisUtils.prepareLabel(root, "Set your player name", "Arial", 20.0D, 50.0D, 25.0D);
    }

    public void gameChooseDifficultyWindowWrongPlayerName(Pane root) {
        TetrisUtils.prepareLabel(root, "Wrong Name Of Player", "Arial", 20.0D, 50.0D, 5.0D);
    }

    // BUTTONS =========================================================================================================

    public Button gameChooseDifficultyWindowCancelButton(Pane root) {
        return TetrisUtils.prepareButton(root, "Cancel", 100.0D, 50.0D, 160.0D, 220.0D);
    }

    public Button gameChooseDifficultyWindowPlayButton(Pane root) {
        return TetrisUtils.prepareButton(root, "Play", 100.0D, 50.0D, 40.0D, 220.0D);
    }

    public Button ButtonOKToMainMenuFromHighScore(Pane root) {
        return TetrisUtils.prepareButton(root, "OK", 90.0D, 70.0D, 150.0D, 440.0D);
    }

    public Button ButtonOKToMainMenuFromEndScreen(Pane root) {
        return TetrisUtils.prepareButton(root, "OK", 90.0D, 70.0D, 100.0D, 200.0D);
    }

    public Button ButtonNewGameProperties(Pane root) {
        return TetrisUtils.prepareButton(root, "New Game", 150.0D, 70.0D, 135.0D, 190.0D);
    }

    public Button ButtonHighScoreProperties(Pane root) {
        return TetrisUtils.prepareButton(root, "HighScores", 150.0D, 70.0D, 135.0D, 270.0D);
    }

    public Button ButtonExitProperties(Pane root) {
        return TetrisUtils.prepareButton(root, "Exit", 150.0D, 70.0D, 135.0D, 350.0D);
    }

    // Images  =========================================================================================================

    public void ImageMainMenu(Pane root) {
        TetrisUtils.prepareImage(root, "api/tetris/images/tetris2.jpg", 500.0D, 400.0D);
    }

    public void ImageDataOfUser(Pane root) {
        TetrisUtils.prepareImage(root, "api/tetris/images/data.jpg", 280.0D, 290.0D);
    }

    public void ImageScores(Pane root) {
        TetrisUtils.prepareImage(root, "api/tetris/images/scores.jpg", 290.0D, 290.0D);

    }

    // Radiobutton ====================================================================================================

    public RadioButton RadioButtonEasyProperties() {
        return TetrisUtils.prepareRadiobutton("Easy", 120.0D, 150.0D, "1", true);
    }

    public RadioButton RadioButtonMediumProperties() {
        return TetrisUtils.prepareRadiobutton("Medium", 120.0D, 170.0D, "2", false);
    }

    public RadioButton RadioButtonHardProperties() {
        return TetrisUtils.prepareRadiobutton("Hard", 120.0D, 190.0D, "3", false);
    }

    // TextField =======================================================================================================

    public TextField TextFieldForNameOfPlayerProperties() {
        TextField TextFieldForNameOfPlayer = new TextField();
        TextFieldForNameOfPlayer.setTranslateX(80.0D);
        TextFieldForNameOfPlayer.setTranslateY(70.0D);
        return TextFieldForNameOfPlayer;
    }

}