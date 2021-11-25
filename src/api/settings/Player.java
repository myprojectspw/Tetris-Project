package api.settings;

import javafx.beans.property.SimpleStringProperty;

public class Player {

    private SimpleStringProperty NubmerOfPlayer;
    private SimpleStringProperty NameOfPlayer;
    private SimpleStringProperty ScoreOfPlayer;

    public Player(String NubmerOfPlayer, String NameOfPlayer, String ScoreOfPlayer) {
        this.NubmerOfPlayer = new SimpleStringProperty(NubmerOfPlayer);
        this.NameOfPlayer = new SimpleStringProperty(NameOfPlayer);
        this.ScoreOfPlayer = new SimpleStringProperty(ScoreOfPlayer);
    }

    public String getFirstName() {
        return NubmerOfPlayer.get();
    }

    public void setFirstName(String fName) {
        NubmerOfPlayer.set(fName);
    }

    public String getLastName() {
        return NameOfPlayer.get();
    }

    public void setLastName(String fName) {
        NameOfPlayer.set(fName);
    }

    public String getEmail() {
        return ScoreOfPlayer.get();
    }

    public void setEmail(String fName) {
        ScoreOfPlayer.set(fName);
    }
}
