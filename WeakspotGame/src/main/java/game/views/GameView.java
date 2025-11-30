package game.views;

import game.model.Tank;
import game.utils.JsonLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameView {

    private Stage stage;
    private AnchorPane root;
    private ImageView imageView;

    public GameView(Stage stage) {
        this.stage = stage;

        // Création du conteneur principal
        root = new AnchorPane();

        // Composant image
        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        // L’image se redimensionne avec la fenêtre
        imageView.fitWidthProperty().bind(root.widthProperty());
        imageView.fitHeightProperty().bind(root.heightProperty());

        root.getChildren().add(imageView);

        // Création de la scène
        Scene scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.setTitle("Weakspot Finder");
        stage.show();
    }

    /** Charge une image de tank via le JSON */
    public void loadTank(String jsonFile) {
        try {
            //Tank tank = JsonLoader.loadTank(jsonFile);
        	Tank tank = new Tank("tiger");
            Image img = new Image(tank.getImage());
            imageView.setImage(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImageView getImageView() {
        return imageView;
    }

    public AnchorPane getRoot() {
        return root;
    }
}
