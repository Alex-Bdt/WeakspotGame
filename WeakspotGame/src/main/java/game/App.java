package game;

import game.controllers.MakerController;
import game.views.GameView;
import game.views.MakerView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	/*
    @Override
    public void start(Stage stage) {
        GameView view = new GameView(stage);
        view.loadTank("tiger.json");
    }

    public static void main(String[] args) {

        launch(args);
    }
    
*/
	@Override
    public void start(Stage stage) {
        String imageName = "/pictures/tiger.png";

        MakerView view = new MakerView(imageName);
        MakerController controller = new MakerController(view, imageName);

        Scene scene = new Scene(view.getRoot(), 800, 600);

        stage.setScene(scene);
        stage.setTitle("Zone Selector MVC");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
	
	
	
}


//    	Tank tiger = new Tank("tiger");