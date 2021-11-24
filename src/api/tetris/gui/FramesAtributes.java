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

    // Labels
    // Utils
    public void prepareLabel(Pane root, String name, String fontName, double fontSize, double positionX, double positionY ) {
        Label customLabel = new Label(name );
        customLabel.setFont(new Font(fontName, fontSize));
        customLabel.setTranslateX(positionX);
        customLabel.setTranslateY(positionY);
        customLabel.setTextFill(Color.WHITE);
        root.getChildren().add(customLabel);
    }

    public void prepareLabelScore(Pane root, double score, String fontName, double fontSize, double positionX, double positionY ) {
        Label customLabel = new Label(String.valueOf(score));
        customLabel.setFont(new Font(fontName, fontSize));
        customLabel.setTranslateX(positionX);
        customLabel.setTranslateY(positionY);
        customLabel.setTextFill(Color.WHITE);
        root.getChildren().add(customLabel);
    }

    public void mainWindowLabel(Pane root) {
        prepareLabel(root, "TETRIS", "Arial", 100.0D, 30.0D, 35.0D);
    }

    public void gameOverWindowLabel(Pane root) {
        prepareLabel(root, "GAME OVER", "Arial", 40.0D, 20.0D, 50.0D);
    }

    public void gameScoreWindowLabel(Pane root) {
        prepareLabel(root, "Your Score", "Arial", 40.0D, 40.0D, 100.0D);
    }

    public void gameScoreWindowLabelScore(Pane root, double score) {
        prepareLabelScore(root, score, "Arial", 40.0D, 120.0D, 150.0D);
    }

    public void gameChooseDifficultyWindowGame(Pane root) {
        prepareLabel(root, "Set difficulty level of game", "Arial", 20.0D, 40.0D, 110.0D);
    }

    public void gameChooseDifficultyWindowPlayerNameLabel(Pane root) {
        prepareLabel(root, "Set your player name", "Arial", 20.0D, 50.0D, 25.0D);
    }

    public void LabelWrongNameOfPlayer(Pane root) {
        prepareLabel(root, "Wrong Name Of Player", "Arial", 20.0D, 50.0D, 5.0D);
    }

    // BUTTONS


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