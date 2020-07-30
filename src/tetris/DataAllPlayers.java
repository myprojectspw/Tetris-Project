package tetris;

import java.io.Serializable;
import java.util.LinkedList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataAllPlayers {

    DataAllPlayers() {}

    public void SortAllPlayers(LinkedList<DataPlayer> allplayers) {
        int zmiana = 1;
        DataPlayer pom1 = new DataPlayer();
        DataPlayer pom2 = new DataPlayer();
        DataPlayer pom3 = new DataPlayer();
        while (zmiana > 0) {
            zmiana = 0;
            for (int i = 0; i < allplayers.size() - 1; i++) {
                pom1 = allplayers.get(i);
                pom2 = allplayers.get(i + 1);
                if (pom1.Score < pom2.Score) {
                    pom3.Name_Of_Player = pom2.Name_Of_Player;
                    pom3.Score = pom2.Score;
                    pom2.Name_Of_Player = pom1.Name_Of_Player;
                    pom2.Score = pom1.Score;
                    pom1.Name_Of_Player = pom3.Name_Of_Player;
                    pom1.Score = pom3.Score;
                    zmiana++;
                }
            }
        }
    }

    public void SetNewPlayer(LinkedList<DataPlayer> allplayers, String NameOfPlayer, long score) {
        DataPlayer a = new DataPlayer(NameOfPlayer, score);
        int size = allplayers.size();
        DataPlayer pom = new DataPlayer();
        int k = 0;
        for (int i = 0; i < size; i++) {
            pom = allplayers.get(i);
            if (new String(pom.Name_Of_Player).equals(a.Name_Of_Player)) {
                if (pom.Score < a.Score) {
                    pom.Score = a.Score;
                    k = 1;
                } else {
                    k = 1;
                }
            }
        }
        if (k == 0) {
            allplayers.add(a);
        }
        SortAllPlayers(allplayers);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public TableColumn TableColumnRankOfPlayersProperties() {
        TableColumn TableColumnRankOfPlayers = new TableColumn("Number");
        TableColumnRankOfPlayers.setMinWidth(100);
        TableColumnRankOfPlayers.setCellValueFactory(new PropertyValueFactory<Player, String>("firstName"));
        return TableColumnRankOfPlayers;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public TableColumn TableColumnNameOfPlayersProperties() {
        TableColumn TableColumnNameOfPlayers = new TableColumn("Name");
        TableColumnNameOfPlayers.setMinWidth(100);
        TableColumnNameOfPlayers.setCellValueFactory(new PropertyValueFactory<Player, String>("lastName"));
        return TableColumnNameOfPlayers;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public TableColumn TableColumnScoreOfPlayersProperties() {
        TableColumn TableColumnScoreOfPlayers = new TableColumn("Score");
        TableColumnScoreOfPlayers.setMinWidth(200);
        TableColumnScoreOfPlayers.setCellValueFactory(new PropertyValueFactory<Player, String>("email"));
        return TableColumnScoreOfPlayers;
    }
}

@SuppressWarnings("serial")
class DataPlayer implements Serializable {

    double Score;
    String Name_Of_Player;

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
