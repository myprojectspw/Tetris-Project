package api.tetris.settings;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TetrisUtils {
    // Labels  =========================================================================================================
    // Utils
    public static void prepareLabel(Pane root, String name, String fontName, double fontSize, double positionX, double positionY ) {
        Label customLabel = new Label(name );
        customLabel.setFont(new Font(fontName, fontSize));
        customLabel.setTranslateX(positionX);
        customLabel.setTranslateY(positionY);
        customLabel.setTextFill(Color.WHITE);
        root.getChildren().add(customLabel);
    }

    public static void prepareLabelScore(Pane root, double score, String fontName, double fontSize, double positionX, double positionY ) {
        Label customLabel = new Label(String.valueOf(score));
        customLabel.setFont(new Font(fontName, fontSize));
        customLabel.setTranslateX(positionX);
        customLabel.setTranslateY(positionY);
        customLabel.setTextFill(Color.WHITE);
        root.getChildren().add(customLabel);
    }

    // BUTTONS =========================================================================================================
    // Utils
    public static Button prepareButton(Pane root, String name, double width, double height, double positionX, double positionY) {
        Button customButton = new Button(name);
        customButton.setPrefSize(width, height);
        customButton.setTranslateX(positionX);
        customButton.setTranslateY(positionY);
        root.getChildren().addAll(customButton);
        return customButton;
    }

    // Images  =========================================================================================================
    // Utils
    public static void prepareImage(Pane root, String url, double height, double width) {
        Image image = new Image(url);
        ImageView vi = new ImageView();
        vi.setFitHeight(height);
        vi.setFitWidth(width);
        vi.setImage(image);
        root.getChildren().add(vi);
    }

    // Radiobutton =====================================================================================================
    // Utils
    public static RadioButton prepareRadiobutton(String name, double positionX, double positionY, String userData, boolean selected) {
        RadioButton RadioButtonEasy = new RadioButton(name);
        RadioButtonEasy.setTextFill(Color.WHITE);
        RadioButtonEasy.setTranslateX(positionX);
        RadioButtonEasy.setTranslateY(positionY);
        RadioButtonEasy.setUserData(userData);
        RadioButtonEasy.setSelected(selected);
        return RadioButtonEasy;
    }

    // Others  =========================================================================================================
    public static void ClearScreenForNewWindow(Stage stage, Pane root) {
        root.getChildren().clear();
        stage.close();
    }

    public static void ShowScene(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
}
