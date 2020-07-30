package api.tetris.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class TetrisOthers {

    public TetrisOthers() {}

    // Labels
    // -----------------------------------------------------------------------------
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

    // -----------------------------------------------------------------------------
    // Buttons
    // -----------------------------------------------------------------------------
    public Button ButtonHighScoreProperties(Pane root) {
        Button HighScoresButton = new Button("HighScores");
        HighScoresButton.setPrefSize(90, 70);
        HighScoresButton.setTranslateX(155);
        HighScoresButton.setTranslateY(270);
        root.getChildren()
            .addAll(HighScoresButton);
        return HighScoresButton;
    }

    public Button ButtonNewGameProperties(Pane root) {
        Button ButtonNewGame = new Button("New Game");
        ButtonNewGame.setPrefSize(90, 70);
        ButtonNewGame.setTranslateX(155);
        ButtonNewGame.setTranslateY(190);
        root.getChildren()
            .addAll(ButtonNewGame);
        return ButtonNewGame;
    }

    public Button ButtonExitProperties(Pane root) {
        Button ExitButton = new Button("Exit");
        ExitButton.setPrefSize(90, 70);
        ExitButton.setTranslateX(155);
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

    // -----------------------------------------------------------------------------
    // Images
    // -----------------------------------------------------------------------------
    public void ImageMainMenu(Pane root) {
        Image image = new Image("file:tetris2.jpg");
        ImageView vi = new ImageView();
        vi.setFitHeight(500);
        vi.setFitWidth(400);
        vi.setImage(image);
        root.getChildren()
            .add(vi);
    }

    public void ImageDataOfUser(Pane root) {
        Image image = new Image("file:data.jpg");
        ImageView vi = new ImageView();
        vi.setFitHeight(280);
        vi.setFitWidth(290);
        vi.setImage(image);
        root.getChildren()
            .add(vi);
    }

    public void ImageScores(Pane root) {
        Image image = new Image("file:scores.jpg");
        ImageView vi = new ImageView();
        vi.setFitHeight(290);
        vi.setFitWidth(290);
        vi.setImage(image);
        root.getChildren()
            .add(vi);
    }

    // -----------------------------------------------------------------------------
    // ClearScreen
    // -----------------------------------------------------------------------------
    public void ClearScreenForNewWindow(Stage stage, Pane root) {
        root.getChildren()
            .clear();
        stage.close();
    }

    // -----------------------------------------------------------------------------
    // RadioButtons
    // -----------------------------------------------------------------------------
    public RadioButton RadioButtonEasyProperties() {
        RadioButton RadioButtonEasy = new RadioButton("Easy");
        RadioButtonEasy.setTextFill(Color.WHITE);
        RadioButtonEasy.setTranslateX(120);
        RadioButtonEasy.setTranslateY(150);
        RadioButtonEasy.setUserData("1");
        RadioButtonEasy.setSelected(true);
        return RadioButtonEasy;
    }

    public RadioButton RadioButtonMediumProperties() {
        RadioButton RadioButtonMedium = new RadioButton("Medium");
        RadioButtonMedium.setTextFill(Color.WHITE);
        RadioButtonMedium.setTranslateX(120);
        RadioButtonMedium.setTranslateY(170);
        RadioButtonMedium.setUserData("2");
        return RadioButtonMedium;
    }

    public RadioButton RadioButtonHardProperties() {
        RadioButton RadioButtonHard = new RadioButton("Hard");
        RadioButtonHard.setTextFill(Color.WHITE);
        RadioButtonHard.setTranslateX(120);
        RadioButtonHard.setTranslateY(190);
        RadioButtonHard.setUserData("3");
        return RadioButtonHard;
    }

    // -----------------------------------------------------------------------------
    // TextField
    // -----------------------------------------------------------------------------
    public TextField TextFieldForNameOfPlayerProperties() {
        TextField TextFieldForNameOfPlayer = new TextField();
        TextFieldForNameOfPlayer.setTranslateX(80);
        TextFieldForNameOfPlayer.setTranslateY(70);
        return TextFieldForNameOfPlayer;
    }

    // -----------------------------------------------------------------------------
    // ShowScene
    // -----------------------------------------------------------------------------
    public void ShowScene(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
}
