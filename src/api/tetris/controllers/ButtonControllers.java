//package api.tetris.controllers;
//
//import api.tetris.frames.Frames;
//import api.tetris.gui.FramesAttributes;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import tetris.DataPlayer;
//import tetris.Player;
//import tetris.TetrisUtils;
//import tetris.Tetriso;
//
//import java.util.LinkedList;
//
//public class ButtonControllers {
//
//    public static void ButtonAcctionNewGame(Pane root, Stage stage, TableView<Player> table, ObservableList<Player> data, Scene scene,
//                                     Canvas MainBoard, LinkedList<DataPlayer> allplayers, Canvas DataBoard) {
//
//        Button newgame = FramesAttributes.mainWindowButtonNewGame(root);
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent e) {
//                TetrisUtils.clearScreenForNewWindow(stage, root);
//                Frames.FrameDataOfPlayer(root, stage, table, data, scene, MainBoard, allplayers, DataBoard);
//            }
//        };
//        newgame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
//    }
//
//    public static void setEventButtonEnd(Pane root) {
//        Button Exit = FramesAttributes.mainWindowButtonExit(root);
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
//                System.exit(-1);
//            }
//        };
//        Exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
//    }
//
//    public static void ButtonCancelToBack(Pane root, Stage stage, TableView<Player> table, ObservableList<Player> data, Scene MainScene,
//                                   Canvas MainBoard, LinkedList<DataPlayer> allplayers, Canvas DataBoard) {
//        Button Cancel = FramesAttributes.gamePropertiesWindowButtonCancel(root);
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent e) {
//                Tetriso.WrongName = 0;
////                Frames.FrameMainMenu(root, MainBoard, MainScene, stage, table, data, allplayers, DataBoard);
//            }
//        };
//        Cancel.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
//    }
//
//    public static void ButtonAcctionOKToGame(Pane root, Stage stage, TableView<Player> table, ObservableList<Player> data, Scene scene,
//                                      Canvas MainBoard, Canvas DataBoard, LinkedList<DataPlayer> allplayers) {
//
//        Button Play = FramesAttributes.gamePropertiesWindowButtonPlay(root);
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent e) {
//                if (Tetriso.NameOfPlayer.isEmpty() || Tetriso.NameOfPlayer.matches("^.*[^a-zA-Z].*$")) {
//                    Tetriso.WrongName = 1;
//                    TetrisUtils.clearScreenForNewWindow(stage, root);
//                    Frames.FrameDataOfPlayer(root, stage, table, data, scene, MainBoard, allplayers, DataBoard);
//                } else {
//                    Tetriso.WrongName = 0;
//                    root.getChildren()
//                            .clear();
//                    stage.close();
//                    // Tetriso.TetrisGame(scene);
//                    TetrisGame t = new TetrisGame();
//                    Scene scene = new Scene(t.Create());
//                    t.TetrisGame(root, stage, scene, table, 0, allplayers, MainBoard, data, DataBoard);
////                    Scene scene = new Scene(Create());
////                    TetrisGame(scene);
//                    TetrisUtils.showScene(stage, scene);
//                }
//            }
//        };
//        Play.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
//    }
//    public static void ButtonOKReturn(Pane root, Stage stage, TableView<Player> table, LinkedList<DataPlayer> allplayers, Scene MainScene,
//                               Canvas MainBoard, ObservableList<Player> data, Canvas DataBoard) {
//        Button OK = FramesAttributes.gameOverWindowButtonOK(root);
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent e) {
////                AttributesFile.SaveProgress(allplayers);
////                Frames.FrameMainMenu(root, MainBoard, MainScene, stage, table, data, allplayers, DataBoard);
//            }
//        };
//        OK.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
//    }
//}
