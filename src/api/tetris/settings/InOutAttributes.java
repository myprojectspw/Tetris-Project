package api.tetris.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class InOutAttributes {

    public InOutAttributes() {}

    public void SaveProgress(LinkedList<DataPlayer> allplayers) {
        File file = new File("Game.ser");
        FileOutputStream fileOut = null;
        try {
            ObjectOutputStream out = null;
            fileOut = new FileOutputStream(file);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(allplayers);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public Object LoadProgress(LinkedList<DataPlayer> allplayers) throws ClassNotFoundException {
        Object Obj = new Object();
        File file = new File("Game.ser");
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            Obj = in.readObject();
            in.close();
            LinkedList<DataPlayer> obj2 = (LinkedList<DataPlayer>) Obj;
            return obj2;
        } catch (IOException e) {
            SaveProgress(allplayers);
            System.out.println("There isn't any data of players, please reload program");
            // e.printStackTrace();
            allplayers = (LinkedList<DataPlayer>) Obj;
        }
        return null;
    }
}
