package api.tetris.gui;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

@SuppressWarnings("restriction")
public class TetrisButtons {

    public Button ButtonHighScoreProperties(Pane root) {
        Button HighScoresButton = new Button("HighScores");
        HighScoresButton.setPrefSize(250, 70);
        HighScoresButton.setTranslateX(105);
        HighScoresButton.setTranslateY(270);
        root.getChildren()
            .addAll(HighScoresButton);
        return HighScoresButton;
    }

    public Button ButtonNewGameProperties(Pane root) {
        Button ButtonNewGame = new Button("New Game");
        ButtonNewGame.setPrefSize(250, 70);
        ButtonNewGame.setTranslateX(105);
        ButtonNewGame.setTranslateY(190);
        root.getChildren()
            .addAll(ButtonNewGame);
        return ButtonNewGame;
    }

    public Button ButtonExitProperties(Pane root) {
        Button ExitButton = new Button("Exit");
        ExitButton.setPrefSize(250, 70);
        ExitButton.setTranslateX(105);
        ExitButton.setTranslateY(350);
        root.getChildren()
            .addAll(ExitButton);
        return ExitButton;
    }

    public Button ButtonCancelProperties(Pane root) {
        Button ButtonCancel = new Button("Cancel");
        ButtonCancel.setPrefSize(100, 50);
        ButtonCancel.setTranslateX(160);
        ButtonCancel.setTranslateY(220);
        root.getChildren()
            .addAll(ButtonCancel);
        return ButtonCancel;
    }

    public Button ButtonPlayProperties(Pane root) {
        Button ButtonPlay = new Button("Play");
        ButtonPlay.setPrefSize(100, 50);
        ButtonPlay.setTranslateX(40);
        ButtonPlay.setTranslateY(220);
        root.getChildren()
            .addAll(ButtonPlay);
        return ButtonPlay;
    }

    public Button ButtonOKToMainMenuFromHighScore(Pane root) {
        Button ButtonOKToMainMenuFromHighScore = new Button("OK");
        ButtonOKToMainMenuFromHighScore.setPrefSize(90, 70);
        ButtonOKToMainMenuFromHighScore.setTranslateX(150);
        ButtonOKToMainMenuFromHighScore.setTranslateY(440);
        root.getChildren()
            .add(ButtonOKToMainMenuFromHighScore);
        return ButtonOKToMainMenuFromHighScore;
    }

    public Button ButtonOKToMainMenuFromEndScreen(Pane root) {
        Button ButtonOKToMainMenuFromEndScreen = new Button("OK");
        ButtonOKToMainMenuFromEndScreen.setPrefSize(90, 70);
        ButtonOKToMainMenuFromEndScreen.setTranslateX(100);
        ButtonOKToMainMenuFromEndScreen.setTranslateY(200);
        root.getChildren()
            .addAll(ButtonOKToMainMenuFromEndScreen);
        return ButtonOKToMainMenuFromEndScreen;
    }

}
