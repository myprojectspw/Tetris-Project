package api.tetris.gui;

import api.tetris.gui.mainFrame.MainFrameButtons;
import javafx.scene.Node;
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

public class FramesAtributes {

    public MainFrameButtons mainFrameButtons;

    public FramesAtributes() {
        mainFrameButtons = new MainFrameButtons();
    }

    public void LabelTetrisProperties(Pane root) {
        Label LabelTetris = new Label("TETRIS");
        LabelTetris.setFont(new Font("Arial", 100.0D));
        LabelTetris.setTranslateX(30.0D);
        LabelTetris.setTranslateY(35.0D);
        LabelTetris.setTextFill(Color.VIOLET);
        root.getChildren().add(LabelTetris);
    }

    public void LabelGameOverProperties(Pane root) {
        Label LabelGameOver = new Label("GAME OVER");
        LabelGameOver.setFont(new Font("Arial", 40.0D));
        LabelGameOver.setTranslateX(20.0D);
        LabelGameOver.setTranslateY(50.0D);
        LabelGameOver.setTextFill(Color.WHITE);
        root.getChildren().add(LabelGameOver);
    }

    public void LabelYourScoreProperties(Pane root) {
        Label LabelYourScore = new Label("Your Score");
        LabelYourScore.setFont(new Font("Arial", 40.0D));
        LabelYourScore.setTranslateX(40.0D);
        LabelYourScore.setTranslateY(100.0D);
        LabelYourScore.setTextFill(Color.WHITE);
        root.getChildren().add(LabelYourScore);
    }

    public void LabelScoreProperties(Pane root, double score) {
        Label LabelScore = new Label("" + score);
        LabelScore.setFont(new Font("Arial", 40.0D));
        LabelScore.setTranslateX(120.0D);
        LabelScore.setTranslateY(150.0D);
        LabelScore.setTextFill(Color.WHITE);
        root.getChildren().add(LabelScore);
    }

    public void LabelDifficultyOfGameProperties(Pane root) {
        Label DifficultyOfGame = new Label("Set difficulty level of game");
        DifficultyOfGame.setFont(new Font("Arial", 20.0D));
        DifficultyOfGame.setTranslateX(40.0D);
        DifficultyOfGame.setTranslateY(110.0D);
        DifficultyOfGame.setTextFill(Color.WHITE);
        root.getChildren().add(DifficultyOfGame);
    }

    public void LabelSetPlayerNameProperties(Pane root) {
        Label SetPlayerName = new Label("Set your player name");
        SetPlayerName.setFont(new Font("Arial", 20.0D));
        SetPlayerName.setTranslateX(50.0D);
        SetPlayerName.setTranslateY(25.0D);
        SetPlayerName.setTextFill(Color.WHITE);
        root.getChildren().add(SetPlayerName);
    }

    public void LabelWrongNameOfPlayer(Pane root) {
        Label WrongNameOfPlaye = new Label("Wrong Name Of Player");
        WrongNameOfPlaye.setFont(new Font("Arial", 20.0D));
        WrongNameOfPlaye.setTranslateX(50.0D);
        WrongNameOfPlaye.setTranslateY(5.0D);
        WrongNameOfPlaye.setTextFill(Color.RED);
        root.getChildren().add(WrongNameOfPlaye);
    }


    public Button ButtonCancelProperties(Pane root) {
        Button ButtonCancel = new Button("Cancel");
        ButtonCancel.setPrefSize(100.0D, 50.0D);
        ButtonCancel.setTranslateX(160.0D);
        ButtonCancel.setTranslateY(220.0D);
        root.getChildren().addAll(new Node[]{ButtonCancel});
        return ButtonCancel;
    }

    public Button ButtonPlayProperties(Pane root) {
        Button ButtonPlay = new Button("Play");
        ButtonPlay.setPrefSize(100.0D, 50.0D);
        ButtonPlay.setTranslateX(40.0D);
        ButtonPlay.setTranslateY(220.0D);
        root.getChildren().addAll(new Node[]{ButtonPlay});
        return ButtonPlay;
    }

    public Button ButtonOKToMainMenuFromHighScore(Pane root) {
        Button ButtonOKToMainMenuFromHighScore = new Button("OK");
        ButtonOKToMainMenuFromHighScore.setPrefSize(90.0D, 70.0D);
        ButtonOKToMainMenuFromHighScore.setTranslateX(150.0D);
        ButtonOKToMainMenuFromHighScore.setTranslateY(440.0D);
        root.getChildren().add(ButtonOKToMainMenuFromHighScore);
        return ButtonOKToMainMenuFromHighScore;
    }

    public Button ButtonOKToMainMenuFromEndScreen(Pane root) {
        Button ButtonOKToMainMenuFromEndScreen = new Button("OK");
        ButtonOKToMainMenuFromEndScreen.setPrefSize(90.0D, 70.0D);
        ButtonOKToMainMenuFromEndScreen.setTranslateX(100.0D);
        ButtonOKToMainMenuFromEndScreen.setTranslateY(200.0D);
        root.getChildren().addAll(new Node[]{ButtonOKToMainMenuFromEndScreen});
        return ButtonOKToMainMenuFromEndScreen;
    }

    public void ImageMainMenu(Pane root) {
        Image image = new Image("api/tetris/images/tetris2.jpg");
        ImageView vi = new ImageView();
        vi.setFitHeight(500.0D);
        vi.setFitWidth(400.0D);
        vi.setImage(image);
        root.getChildren().add(vi);
    }

    public void ImageDataOfUser(Pane root) {
        Image image = new Image("api/tetris/images/data.jpg");
        ImageView vi = new ImageView();
        vi.setFitHeight(280.0D);
        vi.setFitWidth(290.0D);
        vi.setImage(image);
        root.getChildren().add(vi);
    }

    public void ImageScores(Pane root) {
        Image image = new Image("api/tetris/images/scores.jpg");
        ImageView vi = new ImageView();
        vi.setFitHeight(290.0D);
        vi.setFitWidth(290.0D);
        vi.setImage(image);
        root.getChildren().add(vi);
    }

    public void ClearScreenForNewWindow(Stage stage, Pane root) {
        root.getChildren().clear();
        stage.close();
    }

    public RadioButton RadioButtonEasyProperties() {
        RadioButton RadioButtonEasy = new RadioButton("Easy");
        RadioButtonEasy.setTextFill(Color.WHITE);
        RadioButtonEasy.setTranslateX(120.0D);
        RadioButtonEasy.setTranslateY(150.0D);
        RadioButtonEasy.setUserData("1");
        RadioButtonEasy.setSelected(true);
        return RadioButtonEasy;
    }

    public RadioButton RadioButtonMediumProperties() {
        RadioButton RadioButtonMedium = new RadioButton("Medium");
        RadioButtonMedium.setTextFill(Color.WHITE);
        RadioButtonMedium.setTranslateX(120.0D);
        RadioButtonMedium.setTranslateY(170.0D);
        RadioButtonMedium.setUserData("2");
        return RadioButtonMedium;
    }

    public RadioButton RadioButtonHardProperties() {
        RadioButton RadioButtonHard = new RadioButton("Hard");
        RadioButtonHard.setTextFill(Color.WHITE);
        RadioButtonHard.setTranslateX(120.0D);
        RadioButtonHard.setTranslateY(190.0D);
        RadioButtonHard.setUserData("3");
        return RadioButtonHard;
    }

    public TextField TextFieldForNameOfPlayerProperties() {
        TextField TextFieldForNameOfPlayer = new TextField();
        TextFieldForNameOfPlayer.setTranslateX(80.0D);
        TextFieldForNameOfPlayer.setTranslateY(70.0D);
        return TextFieldForNameOfPlayer;
    }

    public void ShowScene(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
}