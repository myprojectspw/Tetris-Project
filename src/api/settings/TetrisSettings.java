package api.settings;

import api.gui.FramesAttributes;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class TetrisSettings {
    private Pane root;
    private Stage primaryStage;
    private Canvas gameOverBoard;
    private Scene scene;
    private TableView<Player> table;
    private LinkedList<DataPlayer> allplayers;
    private Canvas mainBoard;
    private ObservableList<Player> data;
    private Canvas dataBoard;
    private Canvas highScoresBoard;
    private GraphicsContext graphicsContext;
    private Canvas gameBoard;

    private FramesAttributes framesAtributes;
    private InOutAttributes AttributesFile;
    private DataAllPlayers AttributesData;

    private int wrongName;
    private String nameOfPlayer = new String();
    private int difficultyLevel;
    private long score;


    public TetrisSettings() {}

    public TetrisSettings(Pane root, Stage primaryStage, Canvas gameOverBoard, Scene scene, TableView<Player> table, LinkedList<DataPlayer> allplayers, Canvas mainBoard, ObservableList<Player> data, Canvas dataBoard) {
        this.root = root;
        this.primaryStage = primaryStage;
        this.gameOverBoard = gameOverBoard;
        this.scene = scene;
        this.table = table;
        this.allplayers = allplayers;
        this.mainBoard = mainBoard;
        this.data = data;
        this.dataBoard = dataBoard;
    }

    public Pane getRoot() {
        return root;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Canvas getGameOverBoard() {
        return gameOverBoard;
    }

    public Scene getScene() {
        return scene;
    }

    public TableView<Player> getTable() {
        return table;
    }

    public LinkedList<DataPlayer> getAllplayers() {
        return allplayers;
    }

    public Canvas getMainBoard() {
        return mainBoard;
    }

    public ObservableList<Player> getData() {
        return data;
    }

    public Canvas getDataBoard() {
        return dataBoard;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setGameOverBoard(Canvas gameOverBoard) {
        this.gameOverBoard = gameOverBoard;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setTable(TableView<Player> table) {
        this.table = table;
    }

    public void setAllplayers(LinkedList<DataPlayer> allplayers) {
        this.allplayers = allplayers;
    }

    public void setMainBoard(Canvas mainBoard) {
        this.mainBoard = mainBoard;
    }

    public void setData(ObservableList<Player> data) {
        this.data = data;
    }

    public void setDataBoard(Canvas dataBoard) {
        this.dataBoard = dataBoard;
    }
    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public Canvas getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Canvas gameBoard) {
        this.gameBoard = gameBoard;
    }

    public FramesAttributes getFramesAtributes() {
        return framesAtributes;
    }

    public void setFramesAtributes(FramesAttributes framesAtributes) {
        this.framesAtributes = framesAtributes;
    }

    public InOutAttributes getAttributesFile() {
        return AttributesFile;
    }

    public void setAttributesFile(InOutAttributes attributesFile) {
        AttributesFile = attributesFile;
    }

    public DataAllPlayers getAttributesData() {
        return AttributesData;
    }

    public void setAttributesData(DataAllPlayers attributesData) {
        AttributesData = attributesData;
    }

    public int getWrongName() {
        return wrongName;
    }

    public void setWrongName(int wrongName) {
        this.wrongName = wrongName;
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public Canvas getHighScoresBoard() {
        return highScoresBoard;
    }

    public void setHighScoresBoard(Canvas highScoresBoard) {
        this.highScoresBoard = highScoresBoard;
    }
}
