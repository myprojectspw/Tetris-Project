package api.tetris.gui.mainFrame;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainFrameButtons {
    public MainFrameButtons() {
    }

    public Button ButtonNewGameProperties(Pane root) {
        Button ButtonNewGame = new Button("New Game");
        ButtonNewGame.setPrefSize(150.0D, 70.0D);
        ButtonNewGame.setTranslateX(135.0D);
        ButtonNewGame.setTranslateY(190.0D);
        root.getChildren().addAll(new Node[]{ButtonNewGame});
        return ButtonNewGame;
    }

    public Button ButtonHighScoreProperties(Pane root) {
        Button HighScoresButton = new Button("HighScores");
        HighScoresButton.setPrefSize(150.0D, 70.0D);
        HighScoresButton.setTranslateX(135.0D);
        HighScoresButton.setTranslateY(270.0D);
        root.getChildren().addAll(new Node[]{HighScoresButton});
        return HighScoresButton;
    }

    public Button ButtonExitProperties(Pane root) {
        Button ExitButton = new Button("Exit");
        ExitButton.setPrefSize(150.0D, 70.0D);
        ExitButton.setTranslateX(135.0D);
        ExitButton.setTranslateY(350.0D);
        root.getChildren().addAll(new Node[]{ExitButton});
        return ExitButton;
    }
}
