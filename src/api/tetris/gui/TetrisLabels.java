package api.tetris.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

@SuppressWarnings("restriction")
public class TetrisLabels {

    public void LabelTetrisProperties(Pane root) {
        Label LabelTetris = new Label("TETRIS");
        LabelTetris.setFont(new Font("Arial", 100));
        LabelTetris.setTranslateX(30);
        LabelTetris.setTranslateY(35);
        LabelTetris.setTextFill(Color.VIOLET);
        root.getChildren()
            .add(LabelTetris);
    }

    public void LabelGameOverProperties(Pane root) {
        Label LabelGameOver = new Label("GAME OVER");
        LabelGameOver.setFont(new Font("Arial", 40));
        LabelGameOver.setTranslateX(20);
        LabelGameOver.setTranslateY(50);
        LabelGameOver.setTextFill(Color.WHITE);
        root.getChildren()
            .add(LabelGameOver);
    }

    public void LabelYourScoreProperties(Pane root) {
        Label LabelYourScore = new Label("Your Score");
        LabelYourScore.setFont(new Font("Arial", 40));
        LabelYourScore.setTranslateX(40);
        LabelYourScore.setTranslateY(100);
        LabelYourScore.setTextFill(Color.WHITE);
        root.getChildren()
            .add(LabelYourScore);
    }

    public void LabelScoreProperties(Pane root, double score) {
        Label LabelScore = new Label("" + score);
        LabelScore.setFont(new Font("Arial", 40));
        LabelScore.setTranslateX(120);
        LabelScore.setTranslateY(150);
        LabelScore.setTextFill(Color.WHITE);
        root.getChildren()
            .add(LabelScore);
    }

    public void LabelDifficultyOfGameProperties(Pane root) {
        Label DifficultyOfGame = new Label("Set difficulty level of game");
        DifficultyOfGame.setFont(new Font("Arial", 20));
        DifficultyOfGame.setTranslateX(40);
        DifficultyOfGame.setTranslateY(110);
        DifficultyOfGame.setTextFill(Color.WHITE);
        root.getChildren()
            .add(DifficultyOfGame);
    }

    public void LabelSetPlayerNameProperties(Pane root) {
        Label SetPlayerName = new Label("Set your player name");
        SetPlayerName.setFont(new Font("Arial", 20));
        SetPlayerName.setTranslateX(50);
        SetPlayerName.setTranslateY(25);
        SetPlayerName.setTextFill(Color.WHITE);
        root.getChildren()
            .add(SetPlayerName);
    }

    public void LabelWrongNameOfPlayer(Pane root) {
        Label WrongNameOfPlaye = new Label("Wrong Name Of Player");
        WrongNameOfPlaye.setFont(new Font("Arial", 20));
        WrongNameOfPlaye.setTranslateX(50);
        WrongNameOfPlaye.setTranslateY(5);
        WrongNameOfPlaye.setTextFill(Color.RED);
        root.getChildren()
            .add(WrongNameOfPlaye);
    }
}
