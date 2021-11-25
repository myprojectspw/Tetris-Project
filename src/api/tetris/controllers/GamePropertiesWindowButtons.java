package api.tetris.controllers;

import api.tetris.TetrisSettings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import tetris.TetrisUtils;
import tetris.Tetriso;

public class GamePropertiesWindowButtons {
    // WINDOW
    public static void FrameDataOfPlayer(TetrisSettings tetrisSettings) {
        TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());
        tetrisSettings.getRoot().getChildren()
                .addAll(tetrisSettings.getDataBoard());
        tetrisSettings.getFramesAtributes().gamePropertiesWindowImage(tetrisSettings.getRoot());
        tetrisSettings.getFramesAtributes().gamePropertiesWindowPlayerNameLabel(tetrisSettings.getRoot());
        if (tetrisSettings.getWrongName() == 1) {
            tetrisSettings.getFramesAtributes().gamePropertiesWindowWrongPlayerName(tetrisSettings.getRoot());
        }
        tetrisSettings.getFramesAtributes().gamePropertiesWindowChoseLevel(tetrisSettings.getRoot());
        TextField NamePlayer = tetrisSettings.getFramesAtributes().gamePropertiesWindowTextField();

        tetrisSettings.setNameOfPlayer("");
        NamePlayer.textProperty()
                .addListener((observable, oldValue, newValue) -> {
                    tetrisSettings.setNameOfPlayer(newValue);
                });

        tetrisSettings.setDifficultyLevel(1);
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
        ButtonAcctionOKToGame(tetrisSettings);
        ButtonCancelToBack(tetrisSettings);
        tetrisSettings.getRoot().getChildren()
                .addAll(NamePlayer, Easy, Medium, Hard);
        TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), tetrisSettings.getScene());
    }
    // CONTROL BUTTONS
    public static void ButtonAcctionOKToGame(TetrisSettings tetrisSettings) {
        // Tetriso.i te funkcje

        Button Play = tetrisSettings.getFramesAtributes().gamePropertiesWindowButtonPlay(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                if (tetrisSettings.getNameOfPlayer().isEmpty() || tetrisSettings.getNameOfPlayer().matches("^.*[^a-zA-Z].*$")) {
                    tetrisSettings.setWrongName(1);
                    TetrisUtils.ClearScreenForNewWindow(tetrisSettings.getPrimaryStage(), tetrisSettings.getRoot());

                    FrameDataOfPlayer(tetrisSettings);
                } else {
                    tetrisSettings.setWrongName(0);
                    tetrisSettings.getRoot().getChildren()
                            .clear();
                    tetrisSettings.getPrimaryStage().close();
                    TetrisGame tetrs = new TetrisGame(tetrisSettings);
                    tetrs.SetNewValues();
                    // Tetriso.TetrisGame(scene);
                    Scene scene = new Scene(tetrs.Create());
                    tetrs.TetrisGame(scene);
                    TetrisUtils.ShowScene(tetrisSettings.getPrimaryStage(), scene);
                }
            }
        };
        Play.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void ButtonCancelToBack(TetrisSettings tetrisSettings) {
        Button Cancel = tetrisSettings.getFramesAtributes().gamePropertiesWindowButtonCancel(tetrisSettings.getRoot());
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                tetrisSettings.setWrongName(0);
                MainWindowButtons.FrameMainMenu(tetrisSettings);
            }
        };
        Cancel.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
}
