package api.settings;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DataPlayer implements Serializable {

    public double Score;
    public String Name_Of_Player;

    public DataPlayer() {
        this.Score = 0;
    }

    public DataPlayer(String Name_Of_Player, double Score) {
        this.Score = Score;
        this.Name_Of_Player = Name_Of_Player;

    }

    public void Show_Data_Of_Customer() {
        System.out.println(this.Name_Of_Player + " " + this.Score);
    }
}
