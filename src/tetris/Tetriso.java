package tetris;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import api.tetris.gui.FramesAttributes;

public class Tetriso extends Application {

    public static LinkedList<DataPlayer> allplayers = new LinkedList<>();
    private TableView<Player> table = new TableView<>();
    private ObservableList<Player> data = FXCollections.observableArrayList();
    private Canvas GameBoard;
    private Canvas MainBoard;
    private Canvas DataBoard;
    private Canvas GameOverBoard;
    private GraphicsContext gc;
    private Pane root;
    private Stage primaryStage;
    private Scene MainScene;
    private AnimationTimer timer;
    private FramesAttributes framesAtributes;
    private InOutAttributes AttributesFile;
    private DataAllPlayers AttributesData;
    private int WrongName;

    @Override
    public void start(Stage stage) {
        SetMainPropertiesForGame();
        try {
            allplayers = (LinkedList<DataPlayer>) AttributesFile.LoadProgress(allplayers);
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
            System.out.println("Cannot found database of players, please reload application");
        }

        primaryStage = stage;
        MainScene = new Scene(root);

        FrameMainMenu(root, MainBoard, MainScene, primaryStage, table, data, allplayers, DataBoard);
        // primaryStage.setResizable(false);


    }

    public static void main(String[] args) {
        launch(args);
    }

    public void SetMainPropertiesForGame() {
        root = new Pane();
        GameBoard = new Canvas(600, 600);
        MainBoard = new Canvas(400, 460);
        DataBoard = new Canvas(290, 280);
        GameOverBoard = new Canvas(290, 280);
        gc = GameBoard.getGraphicsContext2D();
        framesAtributes = new FramesAttributes();
        AttributesFile = new InOutAttributes();
        AttributesData = new DataAllPlayers();


    }
    // --------------------------------------------------------------------------------
    // Frames
    // --------------------------------------------------------------------------------

    public void FrameMainMenu(Pane root, Canvas MainBoard, Scene scene, Stage stage, TableView<Player> table, ObservableList<Player> data,
            LinkedList<DataPlayer> allplayers, Canvas DataBoard) {
        // New window prepare
        TetrisUtils.ClearScreenForNewWindow(stage, root);
        framesAtributes.mainWindowImage(root);
        framesAtributes.mainWindowLabelMain(root);
        root.getChildren()
            .addAll(MainBoard);
        // Menu
        ButtonAcctionNewGame(root, stage, table, data, scene, MainBoard, allplayers, DataBoard);
        FrameHighScores(root, stage, table, data, allplayers, scene, MainBoard, DataBoard);
        ButtonAcctionEnd(root);

        TetrisUtils.ShowScene(stage, scene);
    }


    public void FrameHighScores(Pane root, Stage stage, TableView<Player> table, ObservableList<Player> data,
            LinkedList<DataPlayer> allplayers, Scene MainScene, Canvas MainBoard, Canvas DataBoard) {
        Button HighScore = framesAtributes.mainWindowButtonHighScores(root);
        HighScore.setStyle("-fx-background-color: #ff0000; ");
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            @SuppressWarnings("unchecked")
            public void handle(MouseEvent e) {
                TetrisUtils.ClearScreenForNewWindow(stage, root);
                Scene scene = new Scene(new Group());
                stage.setTitle("Tetris");

                Label label = new Label("Scores of All Players");
                label.setFont(new Font("Arial", 20));

                table.setEditable(true);

                @SuppressWarnings("rawtypes")
                TableColumn RankOfPlayers = AttributesData.TableColumnRankOfPlayersProperties();
                @SuppressWarnings("rawtypes")
                TableColumn NameOfPlayers = AttributesData.TableColumnNameOfPlayersProperties();
                @SuppressWarnings("rawtypes")
                TableColumn ScoreOfPlayers = AttributesData.TableColumnScoreOfPlayersProperties();
                // Tetriso
                SetPlayersToTable(allplayers, data);
                table.setItems(data);
                table.getColumns()
                     .addAll(RankOfPlayers, NameOfPlayers, ScoreOfPlayers);

                Button OKToMenu = framesAtributes.highScoresWindowButtonOK(root);

                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent e) {
                        table.getColumns()
                             .clear();
                        data.clear();
                        FrameMainMenu(root, MainBoard, MainScene, stage, table, data, allplayers, DataBoard);
                    }
                };
                OKToMenu.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

                VBox vbox = new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10, 0, 0, 10));
                vbox.getChildren()
                    .addAll(label, table);

                ((Group) scene.getRoot()).getChildren()
                                         .addAll(vbox, OKToMenu);

                TetrisUtils.ShowScene(stage, scene);
            }
        };
        HighScore.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void FrameDataOfPlayer(Pane root, Stage stage, TableView<Player> table, ObservableList<Player> data, Scene MainScene,
            Canvas MainBoard, LinkedList<DataPlayer> allplayers, Canvas DataBoard) {
        TetrisUtils.ClearScreenForNewWindow(stage, root);
        root.getChildren()
            .addAll(DataBoard);
        framesAtributes.gamePropertiesWindowImage(root);
        framesAtributes.gamePropertiesWindowPlayerNameLabel(root);
        if (WrongName == 1) {
            framesAtributes.gamePropertiesWindowWrongPlayerName(root);
        }
        framesAtributes.gamePropertiesWindowChoseLevel(root);
        TextField NamePlayer = framesAtributes.gamePropertiesWindowTextField();

        NameOfPlayer = "";
        NamePlayer.textProperty()
                  .addListener((observable, oldValue, newValue) -> {
                      NameOfPlayer = newValue;
                  });

        DifficultyLevel = 1;
        ToggleGroup group = new ToggleGroup();

        RadioButton Easy = framesAtributes.gamePropertiesWindowEasy();
        Easy.setToggleGroup(group);

        RadioButton Medium = framesAtributes.gamePropertiesWindowMedium();
        Medium.setToggleGroup(group);

        RadioButton Hard = framesAtributes.gamePropertiesWindowHard();
        Hard.setToggleGroup(group);

        group.selectedToggleProperty()
             .addListener(new ChangeListener<Toggle>() {

                 @Override
                 public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                     if (group.getSelectedToggle() != null) {
                         DifficultyLevel = Integer.parseInt(group.getSelectedToggle()
                                                                 .getUserData()
                                                                 .toString());
                     }
                 }
             });
        ButtonAcctionOKToGame(root, stage, table, data, MainScene, MainBoard, DataBoard, allplayers);
        ButtonCancelToBack(root, stage, table, data, MainScene, MainBoard, allplayers, DataBoard);
        root.getChildren()
            .addAll(NamePlayer, Easy, Medium, Hard);
        TetrisUtils.ShowScene(stage, MainScene);
    }

    public void FrameEndScreen(Pane root, Stage stage, Canvas GameOverBoard, Scene MainScene, TableView<Player> table, long score,
            LinkedList<DataPlayer> allplayers, Canvas MainBoard, ObservableList<Player> data, Canvas DataBoard) {
        TetrisUtils.ClearScreenForNewWindow(stage, root);
        root.getChildren()
            .addAll(GameOverBoard);
        framesAtributes.gameOverWindowImage(root);
        framesAtributes.gameOverWindowLabelMain(root);
        framesAtributes.gameOverWindowLabelScore(root);
        framesAtributes.gameOverWindowLabelScoreValue(root, score);
        ButtonOKReturn(root, stage, table, allplayers, MainScene, MainBoard, data, DataBoard);
        TetrisUtils.ShowScene(stage, MainScene);
    }
    // --------------------------------------------------------------------------------
    // ButtonActions
    // --------------------------------------------------------------------------------

    public void ButtonAcctionNewGame(Pane root, Stage stage, TableView<Player> table, ObservableList<Player> data, Scene scene,
            Canvas MainBoard, LinkedList<DataPlayer> allplayers, Canvas DataBoard) {
        //
        SetNewValues();
        Button Newgame = framesAtributes.mainWindowButtonNewGame(root);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                TetrisUtils.ClearScreenForNewWindow(stage, root);
                FrameDataOfPlayer(root, stage, table, data, scene, MainBoard, allplayers, DataBoard);
            }
        };
        Newgame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void ButtonAcctionEnd(Pane root) {
        Button Exit = framesAtributes.mainWindowButtonExit(root);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                System.exit(-1);
            }
        };
        Exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void ButtonAcctionOKToGame(Pane root, Stage stage, TableView<Player> table, ObservableList<Player> data, Scene scene,
            Canvas MainBoard, Canvas DataBoard, LinkedList<DataPlayer> allplayers) {
        // Tetriso.i te funkcje
        SetNewValues();
        repaint();
        init();
        Button Play = framesAtributes.gamePropertiesWindowButtonPlay(root);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                if (NameOfPlayer.isEmpty() || NameOfPlayer.matches("^.*[^a-zA-Z].*$")) {
                    WrongName = 1;
                    TetrisUtils.ClearScreenForNewWindow(stage, root);
                    FrameDataOfPlayer(root, stage, table, data, scene, MainBoard, allplayers, DataBoard);
                } else {
                    WrongName = 0;
                    root.getChildren()
                        .clear();
                    stage.close();
                    // Tetriso.TetrisGame(scene);
                    Scene scene = new Scene(Create());
                    TetrisGame(scene);
                    TetrisUtils.ShowScene(stage, scene);
                }
            }
        };
        Play.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void ButtonCancelToBack(Pane root, Stage stage, TableView<Player> table, ObservableList<Player> data, Scene MainScene,
            Canvas MainBoard, LinkedList<DataPlayer> allplayers, Canvas DataBoard) {
        Button Cancel = framesAtributes.gamePropertiesWindowButtonCancel(root);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                WrongName = 0;
                FrameMainMenu(root, MainBoard, MainScene, stage, table, data, allplayers, DataBoard);
            }
        };
        Cancel.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void ButtonOKReturn(Pane root, Stage stage, TableView<Player> table, LinkedList<DataPlayer> allplayers, Scene MainScene,
            Canvas MainBoard, ObservableList<Player> data, Canvas DataBoard) {
        Button OK = framesAtributes.gameOverWindowButtonOK(root);
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                AttributesFile.SaveProgress(allplayers);
                FrameMainMenu(root, MainBoard, MainScene, stage, table, data, allplayers, DataBoard);
            }
        };
        OK.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
    // --------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------

    public Player player;

    public void SetPlayersToTable(LinkedList<DataPlayer> allplayers, ObservableList<Player> data) {
        int size = allplayers.size();
        DataPlayer pom = new DataPlayer();
        for (int i = 0; i < size; i++) {
            pom = allplayers.get(i);
            player = new Player(String.valueOf(i + 1), pom.Name_Of_Player, String.valueOf(pom.Score));
            data.add(player);
        }
    }

    // ---------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------
    private double EasyLevel = 0.5;
    private double MediumLevel = 0.35;
    private double HardLevel = 0.2;
    private double time;
    private Point pieceOrigin;
    private int currentPiece;
    private int rotation;
    private ArrayList<Integer> nextPieces = new ArrayList<>();
    private long score;
    private String NameOfPlayer = new String();
    private int DifficultyLevel;
    private Color[][] well;
    private Point[][][] Tetraminos = {
            // I-Piece
            {{new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)}},
            // J-Piece
            {{new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0)}},
            // L-Piece
            {{new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0)}},
            // O-Piece
            {{new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)}},
            // S-Piece
            {{new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
                    {new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)}},
            // T-Piece
            {{new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)},
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2)},
                    {new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2)}},
            // Z-Piece
            {{new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)},
                    {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)}}};
    private Color[] tetraminoColors = {Color.CYAN, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.PINK, Color.RED};

    public void TetrisGame(Scene scene) {
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case SPACE:
                    break;
                case UP:
                    rotate(+1);
                    break;
                case LEFT:
                    move(-1);
                    break;
                case RIGHT:
                    move(+1);
                    break;
                case DOWN:
                    score += DifficultyLevel();
                    moveDown(+1);
                    break;
                default:
                    break;
            }
        });
        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                time += 0.017;

                if (time >= ChooseLevel()) {
                    moveDown(+1);
                    time = 0;
                }
            }
        };
        timer.start();
    }

    public double ChooseLevel() {
        if (DifficultyLevel == 1) {
            return EasyLevel;
        }
        if (DifficultyLevel == 2) {
            return MediumLevel;
        } else {
            return HardLevel;
        }

    }

    public Parent Create() {
        Pane RootForTetris = new Pane();
        RootForTetris.getChildren()
                     .addAll(GameBoard);
        repaint();
        return RootForTetris;
    }

    public void SetNewValues() {
        repaint();
        init();
        currentPiece = 0;
        rotation = 0;
        score = 0;
    }

    @Override
    public void init() {
        well = new Color[12][24];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                if (i == 0 || i == 11 || j == 22) {
                    well[i][j] = Color.GRAY;
                } else {
                    well[i][j] = Color.BLACK;
                }
            }
        }
        newPiece();
    }

    public void MakeBoard(GraphicsContext r) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                r.setFill(well[i][j]);
                r.fillRect(26 * i, 26 * j, 25, 25);
            }
        }
    }

    public void newPiece() {
        pieceOrigin = new Point(5, 0);
        rotation = 0;
        if (nextPieces.isEmpty()) {
            Collections.addAll(nextPieces, 0, 1, 2, 3, 4, 5, 6);
            Collections.shuffle(nextPieces);
        }
        currentPiece = nextPieces.get(0);
        nextPieces.remove(0);

        if ((collidesAt(5, 1, rotation) || collidesAt(4, 1, rotation) || collidesAt(6, 1, rotation)) == true) {
            timer.stop();
            AttributesData.SetNewPlayer(allplayers, NameOfPlayer, score);
            FrameEndScreen(root, primaryStage, GameOverBoard, MainScene, table, score, allplayers, MainBoard, data, DataBoard);
        }
    }

    public void move(int i) {
        if (!collidesAt(pieceOrigin.x + i, pieceOrigin.y, rotation)) {
            pieceOrigin.x += i;
        }
        repaint();
    }

    public void moveDown(int i) {
        if (collidesAt(pieceOrigin.x, pieceOrigin.y + i, rotation) != true) {
            pieceOrigin.y += i;
        } else {
            fixToWell();
        }
        repaint();
    }

    public void rotate(int i) {
        int newRotation = (rotation + i) % 4;
        if (newRotation < 0) {
            newRotation = 3;
        }
        if (!collidesAt(pieceOrigin.x, pieceOrigin.y, newRotation)) {
            rotation = newRotation;
        }
        repaint();
    }

    boolean collidesAt(int x, int y, int rotation) {
        for (Point p : Tetraminos[currentPiece][rotation]) {
            if (well[p.x + x][p.y + y] != Color.BLACK) {
                return true;
            }
        }
        return false;
    }

    public void repaint() {
        gc.clearRect(0, 0, GameBoard.getWidth(), GameBoard.getHeight());
        MakeBoard(gc);
        drawPiece(gc);
        gc.strokeText("" + score, 40 * 12, 25);
        gc.strokeText("Instruction", 30 * 12, 100);
        gc.strokeText("KEY.UP - Rotation of Block", 30 * 12, 120);
        gc.strokeText("KEY.DWON - Faster falling a Block", 30 * 12, 140);
        gc.strokeText("KEY.LEFT - Block goes left", 30 * 12, 160);
        gc.strokeText("KEY.RIGHT - Block goes right", 30 * 12, 180);
    }

    public void fixToWell() {
        for (Point p : Tetraminos[currentPiece][rotation]) {
            well[pieceOrigin.x + p.x][pieceOrigin.y + p.y] = tetraminoColors[currentPiece];
        }
        ClearRows();
        newPiece();
    }

    boolean ClearRows() {
        boolean gap;
        int numClears = 0;
        for (int j = 21; j > 0; j--) {
            gap = false;
            for (int i = 1; i < 11; i++) {
                if (well[i][j] == Color.BLACK) {
                    gap = true;
                    break;
                }
            }
            if (gap != true) {
                deleteRow(j);
                j += 1;
                numClears += 1;
            }
        }
        score += numClears * DifficultyLevel() * 100;
        return false;
    }

    public int DifficultyLevel() {
        if (DifficultyLevel == 1) {
            return 1;
        }
        if (DifficultyLevel == 2) {
            return 2;
        }
        if (DifficultyLevel == 3) {
            return 3;
        } else {
            return 0;
        }
    }

    public void deleteRow(int row) {
        for (int j = row - 1; j > 0; j--) {
            for (int i = 1; i < 11; i++) {
                well[i][j + 1] = well[i][j];
            }
        }
    }

    public void drawPiece(GraphicsContext r) {
        for (Point p : Tetraminos[currentPiece][rotation]) {
            r.setFill(tetraminoColors[currentPiece]);
            r.fillRect((p.x + pieceOrigin.x) * 26, (p.y + pieceOrigin.y) * 26, 25, 25);
        }
    }
}
