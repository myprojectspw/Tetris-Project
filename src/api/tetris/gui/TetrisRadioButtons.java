package api.tetris.gui;

import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

@SuppressWarnings("restriction")
public class TetrisRadioButtons {

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
}
