package game.views;

import game.controllers.MainController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class MainMenu {

	private Scene scene;

    public MainMenu() {
        VBox root = new VBox(20);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Button btnA = new Button("Aller vers A");
        Button btnB = new Button("Aller vers B");

        MainController controller = new MainController();

        btnA.setOnAction(e -> controller.goToMakerView());
        //btnB.setOnAction(e -> controller.goToB());

        scene = new Scene(root, 400, 250);
        root.getChildren().addAll(btnA, btnB);
    }

    public Scene getScene() {
        return scene;
    }
}