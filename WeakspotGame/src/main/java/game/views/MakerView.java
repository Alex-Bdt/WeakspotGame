package game.views;

import java.util.ArrayList;
import java.util.List;
import game.controllers.MakerController;
import game.utils.JsonSave;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MakerView {

    private Image image;
    private Scene scene;
    private ImageView imageView;
    private BorderPane root;
    private Pane drawLayer;

    public MakerView(String imageName, double fixedWidth, double fixedHeight) {

        root = new BorderPane();

        // Charger l'image
        image = new Image(getClass().getResource(imageName).toExternalForm());
        imageView = new ImageView(image);

        // Taille fixe
        imageView.setFitWidth(fixedWidth);
        imageView.setFitHeight(fixedHeight);

        imageView.setPreserveRatio(true);

        // Zone de dessin au-dessus de l'image
        drawLayer = new Pane();
        	// bind drawLayer à la taille de l'imageView
        drawLayer.prefWidthProperty().bind(imageView.fitWidthProperty());
        drawLayer.prefHeightProperty().bind(imageView.fitHeightProperty());
        	// permet de cliquer sur l'image même transparente
        drawLayer.setPickOnBounds(true); 
        StackPane center = new StackPane(imageView, drawLayer);
        root.setCenter(center);
        
        // --- Boutons en haut ---
        HBox topBar = new HBox(10);
        topBar.setStyle("-fx-padding: 10;");

        Button backButton = new Button("Retour au menu");
        Button saveButton = new Button("Sauvegarder");
        Button clearButton = new Button("Clear");

        // Création du contrôleur
        MakerController controller = new MakerController(this);

        // Action du bouton Retour
        backButton.setOnAction(e -> controller.goBackToMain());
        // Action du bouton Sauvegarde
        saveButton.setOnAction(e -> {
            JsonSave.saveRectangles(this.getImage(), this.getAllRectangles());
        });
        // Action du bouton Clear
        clearButton.setOnAction(e -> {
            this.getDrawLayer().getChildren().clear();
        });
        
        
        topBar.getChildren().addAll(backButton, saveButton, clearButton);
        root.setTop(topBar);
      
        // Créer la scène
        scene = new Scene(root, 800, 600);
    }
    
    public void setImage(String imageName, double w, double h) {
        Image newImage = new Image(imageName);
        imageView.setImage(newImage);
        imageView.setFitWidth(w);
        imageView.setFitHeight(h);
    }

    public Scene getScene() {
        return scene;
    }
    
    public Pane getDrawLayer() {
        return drawLayer;
    }
    
    public Image getImage() { 
    	return image; 
    }
    
    public List<Rectangle> getAllRectangles() { //fait la liste des rectanges via filtre
        return new ArrayList<>(drawLayer.getChildren().stream()
                                      .filter(node -> node instanceof Rectangle)
                                      .map(node -> (Rectangle) node)
                                      .toList());
    }

}
// makerView.getDrawLayer().getChildren().clear();  Enlever les rectangles
