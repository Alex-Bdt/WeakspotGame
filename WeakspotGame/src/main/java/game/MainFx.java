package game;

import game.views.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFx extends Application {

    private static Stage mainStage;

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        setScene(new MainMenu().getScene(), "Menu Principal");
        stage.show();
    }

    public static void setScene(Scene scene, String title) {
        mainStage.setScene(scene);
        mainStage.setTitle(title);
    }
}