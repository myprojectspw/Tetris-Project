package api.tetris.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

@SuppressWarnings("restriction")
public class TetrisImages {

    public void ImageMainMenu(Pane root) {
        Image image = new Image("api/tetris/images/tetris2.jpg");
        ImageView vi = new ImageView();
        vi.setFitHeight(500);
        vi.setFitWidth(400);
        vi.setImage(image);
        root.getChildren().addAll(vi);
        System.out.println("Powinno sie dodac");
    }

    public void ImageDataOfUser(Pane root) {
        Image image = new Image("/api.tetris.images/data.jpg");
        ImageView vi = new ImageView();
        vi.setFitHeight(280);
        vi.setFitWidth(290);
        vi.setImage(image);
        root.getChildren()
            .add(vi);
    }

    public void ImageScores(Pane root) {
        Image image = new Image("/api.tetris.images/scores.jpg");
        ImageView vi = new ImageView();
        vi.setFitHeight(290);
        vi.setFitWidth(290);
        vi.setImage(image);
        root.getChildren()
            .add(vi);
    }
}
