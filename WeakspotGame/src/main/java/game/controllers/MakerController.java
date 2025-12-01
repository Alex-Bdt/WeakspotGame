package game.controllers;

import game.MainFx;
import game.views.MainMenu;
import game.views.MakerView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MakerController {

    private final MakerView view;
    private Rectangle currentRect;
    private double startX, startY;

    public MakerController(MakerView view) {
        this.view = view;
        initMouseEvents();
    }

    private void initMouseEvents() {
        view.getDrawLayer().setOnMousePressed(e -> {
            startX = e.getX();
            startY = e.getY();
            
            currentRect = new Rectangle();
            currentRect.setX(startX);
            currentRect.setY(startY);
            currentRect.setStroke(Color.RED);
            currentRect.setFill(Color.TRANSPARENT);
            currentRect.setStrokeWidth(2);
            
            view.getDrawLayer().getChildren().add(currentRect);
        });

        view.getDrawLayer().setOnMouseDragged(e -> {
            double width = e.getX() - startX;
            double height = e.getY() - startY;
            
            currentRect.setWidth(Math.abs(width));
            currentRect.setHeight(Math.abs(height));
            
            if (width < 0) currentRect.setX(e.getX());
            if (height < 0) currentRect.setY(e.getY());
        });
    }

	public void goBackToMain() {
		MainFx.setScene(new MainMenu().getScene(), "Menu Principal");
	}
}
