package game.views;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MakerView {

    private Pane root = new Pane();
    private ImageView imageView;
    private Image image;

    public MakerView(String imageName) {
        image = new Image(imageName);
        imageView = new ImageView(image);

        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(root.widthProperty());
        imageView.fitHeightProperty().bind(root.heightProperty());

        root.getChildren().add(imageView);
    }

    public Pane getRoot() {
        return root;
    }

    public Image getImage() {
        return image;
    }
}
