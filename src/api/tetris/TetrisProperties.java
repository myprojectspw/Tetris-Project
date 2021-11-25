//package api.tetris;
//
//import javafx.collections.ObservableList;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.control.TableView;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import tetris.DataPlayer;
//import tetris.Player;
//
//import java.util.LinkedList;
//
//public class TetrisProperties {
//    private Pane root;
//    private Stage primaryStage;
//    private Canvas gameOverBoard;
//    private Scene scene;
//    private TableView<Player> table;
//    private LinkedList<DataPlayer> allplayers;
//    private Canvas mainBoard;
//    private ObservableList<Player> data;
//    private Canvas dataBoard;
//
//    public TetrisProperties() {}
//
//    public TetrisProperties(Pane root, Stage primaryStage, Canvas gameOverBoard, Scene scene, TableView<Player> table, LinkedList<DataPlayer> allplayers, Canvas mainBoard, ObservableList<Player> data, Canvas dataBoard) {
//        this.root = root;
//        this.primaryStage = primaryStage;
//        this.gameOverBoard = gameOverBoard;
//        this.scene = scene;
//        this.table = table;
//        this.allplayers = allplayers;
//        this.mainBoard = mainBoard;
//        this.data = data;
//        this.dataBoard = dataBoard;
//    }
//
//    public Pane getRoot() {
//        return root;
//    }
//
//    public Stage getPrimaryStage() {
//        return primaryStage;
//    }
//
//    public Canvas getGameOverBoard() {
//        return gameOverBoard;
//    }
//
//    public Scene getScene() {
//        return scene;
//    }
//
//    public TableView<Player> getTable() {
//        return table;
//    }
//
//    public LinkedList<DataPlayer> getAllplayers() {
//        return allplayers;
//    }
//
//    public Canvas getMainBoard() {
//        return mainBoard;
//    }
//
//    public ObservableList<Player> getData() {
//        return data;
//    }
//
//    public Canvas getDataBoard() {
//        return dataBoard;
//    }
//
//    public void setRoot(Pane root) {
//        this.root = root;
//    }
//
//    public void setPrimaryStage(Stage primaryStage) {
//        this.primaryStage = primaryStage;
//    }
//
//    public void setGameOverBoard(Canvas gameOverBoard) {
//        this.gameOverBoard = gameOverBoard;
//    }
//
//    public void setScene(Scene scene) {
//        this.scene = scene;
//    }
//
//    public void setTable(TableView<Player> table) {
//        this.table = table;
//    }
//
//    public void setAllplayers(LinkedList<DataPlayer> allplayers) {
//        this.allplayers = allplayers;
//    }
//
//    public void setMainBoard(Canvas mainBoard) {
//        this.mainBoard = mainBoard;
//    }
//
//    public void setData(ObservableList<Player> data) {
//        this.data = data;
//    }
//
//    public void setDataBoard(Canvas dataBoard) {
//        this.dataBoard = dataBoard;
//    }
//}
