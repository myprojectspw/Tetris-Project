package api.tetris.controllers;
import api.tetris.TetrisSettings;
import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import tetris.Tetriso;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;



public class TetrisGame {
    //    private Pane root;
//    private Stage primaryStage;
//    private Canvas GameOverBoard;
//    private Scene MainScene;
//    private TableView<Player> table;
//    private LinkedList<DataPlayer> allplayers;
//    private Canvas MainBoard;
//    private ObservableList<Player> data;
//    private Canvas DataBoard;


    private TetrisSettings tetrisSettings;
    private AnimationTimer timer;

    public TetrisGame() {}
    public TetrisGame(TetrisSettings tetrisSettings) {
        this.tetrisSettings = tetrisSettings;
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
    private javafx.scene.paint.Color[][] well;
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
    private javafx.scene.paint.Color[] tetraminoColors = {javafx.scene.paint.Color.CYAN, javafx.scene.paint.Color.BLUE, javafx.scene.paint.Color.ORANGE, javafx.scene.paint.Color.YELLOW, javafx.scene.paint.Color.GREEN, javafx.scene.paint.Color.PINK, javafx.scene.paint.Color.RED};

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
                .addAll(tetrisSettings.getGameBoard());
        repaint();
        return RootForTetris;
    }

    public void SetNewValues() {
        init();
        repaint();

        currentPiece = 0;
        rotation = 0;
        score = 0;
    }

//    @Override
    public void init() {
        well = new javafx.scene.paint.Color[12][24];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                if (i == 0 || i == 11 || j == 22) {
                    well[i][j] = javafx.scene.paint.Color.GRAY;
                } else {
                    well[i][j] = javafx.scene.paint.Color.BLACK;
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
            tetrisSettings.getAttributesData().SetNewPlayer(tetrisSettings.getAllplayers(), tetrisSettings.getNameOfPlayer(), score);
            tetrisSettings.setScore(score);
//            FrameEndScreen(root, primaryStage, GameOverBoard, MainScene, table, score, allplayers, MainBoard, data, DataBoard);
            Tetriso.FrameEndScreen(tetrisSettings);
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
            if (well[p.x + x][p.y + y] != javafx.scene.paint.Color.BLACK) {
                return true;
            }
        }
        return false;
    }

    public void repaint() {
        GraphicsContext gc = tetrisSettings.getGraphicsContext();
        Canvas GameBoard = tetrisSettings.getGameBoard();
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
