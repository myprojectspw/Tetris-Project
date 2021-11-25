package api.windows;

import api.settings.TetrisSettings;
import api.controllers.GamePropertiesWindowButtons;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import api.settings.TetrisUtils;

public class GamePropertiesWindow {
    // Frame
    public static void FrameDataOfPlayer(TetrisSettings tetrisSettings) {
        // Prepare window
        TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
        tetrisSettings.getRoot().getChildren()
                .addAll(tetrisSettings.getDataBoard());

        // Add components
        addGamePropertiesComponents(tetrisSettings);

        // Show notification if player name is wrong
        if (tetrisSettings.getWrongName() == 1) {
            tetrisSettings.getFramesAtributes().gamePropertiesWindowWrongPlayerName(tetrisSettings.getRoot());
        }

        // Add controllers
        GamePropertiesWindowButtons.ButtonActionOKToGame(tetrisSettings);
        GamePropertiesWindowButtons.ButtonCancelToBack(tetrisSettings);

        // Show scene
        TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), tetrisSettings.getScene());
    }
    // Utils
    public static void addGamePropertiesComponents(TetrisSettings tetrisSettings) {
        tetrisSettings.getFramesAtributes().gamePropertiesWindowImage(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gamePropertiesWindowPlayerNameLabel(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gamePropertiesWindowChoseLevel(tetrisSettings.getRoot());

        TextField NamePlayer = tetrisSettings.getFramesAtributes().gamePropertiesWindowTextField();

        tetrisSettings.setNameOfPlayer("");
        NamePlayer.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    tetrisSettings.setNameOfPlayer(newValue);
                });

        tetrisSettings.setDifficultyLevel(1);

        createToogleButtons(tetrisSettings, NamePlayer);
    }

    public static void createToogleButtons(TetrisSettings tetrisSettings, TextField NamePlayer) {
        ToggleGroup group = new ToggleGroup();

        RadioButton Easy = tetrisSettings.getFramesAtributes().gamePropertiesWindowEasy();
        Easy.setToggleGroup(group);

        RadioButton Medium = tetrisSettings.getFramesAtributes().gamePropertiesWindowMedium();
        Medium.setToggleGroup(group);

        RadioButton Hard = tetrisSettings.getFramesAtributes().gamePropertiesWindowHard();
        Hard.setToggleGroup(group);

        group.selectedToggleProperty()
                .addListener(new ChangeListener<Toggle>() {

                    @Override
                    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                        if (group.getSelectedToggle() != null) {
                            tetrisSettings.setDifficultyLevel(Integer.parseInt(group.getSelectedToggle()
                                    .getUserData()
                                    .toString()));
                        }
                    }
                });

        tetrisSettings.getRoot().getChildren()
                .addAll(NamePlayer, Easy, Medium, Hard);
    }
}
