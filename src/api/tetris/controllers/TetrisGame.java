//package api.tetris.controllers;
//
//import api.tetris.frames.Frames;
//import javafx.animation.AnimationTimer;
//import javafx.collections.ObservableList;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.control.TableView;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//import tetris.DataPlayer;
//import tetris.Player;
//import tetris.Tetriso;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//
//import static tetris.Tetriso.*;
//
//public class TetrisGame {
//    private Pane root;
//    private Stage primaryStage;
//    private Canvas GameOverBoard;
//    private Scene MainScene;
//    private TableView<Player> table;
//    private LinkedList<DataPlayer> allplayers;
//    private Canvas MainBoard;
//    private ObservableList<Player> data;
//    private Canvas DataBoard;
//
//    // ---------------------------------------------------------------------------------------
//    // ---------------------------------------------------------------------------------------
//    // ---------------------------------------------------------------------------------------
//    public Canvas GameBoard;
//    private GraphicsContext gc;
//    private AnimationTimer timer;
//
//    private double EasyLevel = 0.5;
//    private double MediumLevel = 0.35;
//    private double HardLevel = 0.2;
//    private double time;
//    private Point pieceOrigin;
//    private int currentPiece;
//    private int rotation;
//    private ArrayList<Integer> nextPieces = new ArrayList<>();
//    private long score;
//
//    private javafx.scene.paint.Color[][] well;
//    private Point[][][] Tetraminos = {
//            // I-Piece
//            {{new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
//                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)},
//                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
//                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)}},
//            // J-Piece
//            {{new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0)},
//                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2)},
//                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2)},
//                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0)}},
//            // L-Piece
//            {{new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2)},
//                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2)},
//                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0)},
//                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0)}},
//            // O-Piece
//            {{new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
//                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
//                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
//                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)}},
//            // S-Piece
//            {{new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
//                    {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
//                    {new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
//                    {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)}},
//            // T-Piece
//            {{new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)},
//                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
//                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2)},
//                    {new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2)}},
//            // Z-Piece
//            {{new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
//                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)},
//                    {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
//                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)}}};
//    private javafx.scene.paint.Color[] tetraminoColors = {javafx.scene.paint.Color.CYAN, javafx.scene.paint.Color.BLUE, javafx.scene.paint.Color.ORANGE, javafx.scene.paint.Color.YELLOW, javafx.scene.paint.Color.GREEN, javafx.scene.paint.Color.PINK, javafx.scene.paint.Color.RED};
//
//    public TetrisGame() {
//        GameBoard = new Canvas(600, 600);
//        GameOverBoard = new Canvas(290, 280);
//        gc = GameBoard.getGraphicsContext2D();
//        init();
//    }
//
//
//    public void TetrisGame(Pane root, Stage stage, Scene MainScene, TableView<Player> table, long score,
//                           LinkedList<DataPlayer> allplayers, Canvas MainBoard, ObservableList<Player> data, Canvas DataBoard) {
//        this.primaryStage = stage;
//        this.root = root;
//        this.MainScene = MainScene;
//        this.table = table;
//        this.score = score;
//        this.allplayers = allplayers;
//        this.MainBoard = MainBoard;
//        this.data = data;
//        this.DataBoard = DataBoard;
//
////        repaint();
//
//        currentPiece = 0;
//        rotation = 0;
//        this.score = 0;
//        MainScene.setOnKeyPressed(e -> {
//            switch (e.getCode()) {
//                case SPACE:
//                    break;
//                case UP:
//                    rotate(+1);
//                    break;
//                case LEFT:
//                    move(-1);
//                    break;
//                case RIGHT:
//                    move(+1);
//                    break;
//                case DOWN:
//                    this.score += DifficultyLevel();
//                    moveDown(+1);
//                    break;
//                default:
//                    break;
//            }
//        });
//        timer = new AnimationTimer() {
//
//            @Override
//            public void handle(long now) {
//                time += 0.017;
//                System.out.println("Timer working");
//
//                if (time >= ChooseLevel()) {
//                    moveDown(+1);
//                    time = 0;
//                }
//            }
//        };
//        timer.start();
//    }
//
//    public double ChooseLevel() {
//        if (Tetriso.DifficultyLevel == 1) {
//            return EasyLevel;
//        }
//        if (Tetriso.DifficultyLevel == 2) {
//            return MediumLevel;
//        } else {
//            return HardLevel;
//        }
//
//    }
//
//    public Parent Create() {
//        Pane RootForTetris = new Pane();
//        RootForTetris.getChildren()
//                .addAll(GameBoard);
//        repaint();
//        return RootForTetris;
//    }
//
//    public void SetNewValues() {
////        repaint();
////        init();
////        currentPiece = 0;
////        rotation = 0;
////        score = 0;
//    }
//
////    @Override
//    public void init() {
//        well = new javafx.scene.paint.Color[12][24];
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 23; j++) {
//                if (i == 0 || i == 11 || j == 22) {
//                    well[i][j] = javafx.scene.paint.Color.GRAY;
//                } else {
//                    well[i][j] = javafx.scene.paint.Color.BLACK;
//                }
//            }
//        }
//        newPiece();
//    }
//
//    public void MakeBoard(GraphicsContext r) {
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 23; j++) {
//                r.setFill(well[i][j]);
//                r.fillRect(26 * i, 26 * j, 25, 25);
//            }
//        }
//    }
//
//    public void newPiece() {
//        pieceOrigin = new Point(5, 0);
//        rotation = 0;
//        if (nextPieces.isEmpty()) {
//            Collections.addAll(nextPieces, 0, 1, 2, 3, 4, 5, 6);
//            Collections.shuffle(nextPieces);
//        }
//        currentPiece = nextPieces.get(0);
//        nextPieces.remove(0);
//
//        if ((collidesAt(5, 1, rotation) || collidesAt(4, 1, rotation) || collidesAt(6, 1, rotation))) {
//            timer.stop();
//            System.out.println("STOPPPP");
//            AttributesData.SetNewPlayer(allplayers, NameOfPlayer, score);
//            Frames.FrameEndScreen(root, primaryStage, GameOverBoard, MainScene, table, score, allplayers, MainBoard, data, DataBoard);
//        }
//    }
//
//    public void move(int i) {
//        if (!collidesAt(pieceOrigin.x + i, pieceOrigin.y, rotation)) {
//            pieceOrigin.x += i;
//        }
//        repaint();
//    }
//
//    public void moveDown(int i) {
//        if (!collidesAt(pieceOrigin.x, pieceOrigin.y + i, rotation)) {
//            pieceOrigin.y += i;
//        } else {
//            fixToWell();
//        }
//        repaint();
//    }
//
//    public void rotate(int i) {
//        int newRotation = (rotation + i) % 4;
//        if (newRotation < 0) {
//            newRotation = 3;
//        }
//        if (!collidesAt(pieceOrigin.x, pieceOrigin.y, newRotation)) {
//            rotation = newRotation;
//        }
//        repaint();
//    }
//
//    boolean collidesAt(int x, int y, int rotation) {
//        for (Point p : Tetraminos[currentPiece][rotation]) {
//            if (well[p.x + x][p.y + y] != javafx.scene.paint.Color.BLACK) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void repaint() {
//        gc.clearRect(0, 0, GameBoard.getWidth(), GameBoard.getHeight());
//        MakeBoard(gc);
//        drawPiece(gc);
//        gc.strokeText("" + score, 40 * 12, 25);
//        gc.strokeText("Instruction", 30 * 12, 100);
//        gc.strokeText("KEY.UP - Rotation of Block", 30 * 12, 120);
//        gc.strokeText("KEY.DWON - Faster falling a Block", 30 * 12, 140);
//        gc.strokeText("KEY.LEFT - Block goes left", 30 * 12, 160);
//        gc.strokeText("KEY.RIGHT - Block goes right", 30 * 12, 180);
//    }
//
//    public void fixToWell() {
//        for (Point p : Tetraminos[currentPiece][rotation]) {
//            well[pieceOrigin.x + p.x][pieceOrigin.y + p.y] = tetraminoColors[currentPiece];
//        }
//        ClearRows();
//        newPiece();
//    }
//
//    boolean ClearRows() {
//        boolean gap;
//        int numClears = 0;
//        for (int j = 21; j > 0; j--) {
//            gap = false;
//            for (int i = 1; i < 11; i++) {
//                if (well[i][j] == Color.BLACK) {
//                    gap = true;
//                    break;
//                }
//            }
//            if (gap != true) {
//                deleteRow(j);
//                j += 1;
//                numClears += 1;
//            }
//        }
//        score += numClears * DifficultyLevel() * 100;
//        return false;
//    }
//
//    public int DifficultyLevel() {
//        if (Tetriso.DifficultyLevel == 1) {
//            return 1;
//        }
//        if (Tetriso.DifficultyLevel == 2) {
//            return 2;
//        }
//        if (Tetriso.DifficultyLevel == 3) {
//            return 3;
//        } else {
//            return 0;
//        }
//    }
//
//    public void deleteRow(int row) {
//        for (int j = row - 1; j > 0; j--) {
//            for (int i = 1; i < 11; i++) {
//                well[i][j + 1] = well[i][j];
//            }
//        }
//    }
//
//    public void drawPiece(GraphicsContext r) {
//        for (Point p : Tetraminos[currentPiece][rotation]) {
//            r.setFill(tetraminoColors[currentPiece]);
//            r.fillRect((p.x + pieceOrigin.x) * 26, (p.y + pieceOrigin.y) * 26, 25, 25);
//        }
//    }
//}
