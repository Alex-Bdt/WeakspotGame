package game.controllers;

import game.utils.JsonSave;
import game.views.MakerView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MakerController {

    private final MakerView view;
    private final String imageName;
    private Rectangle currentRect;
    private double startX, startY;

    public MakerController(MakerView view, String imageName) {
        this.view = view;
        this.imageName = imageName;

        initMouseEvents();
    }

    private void initMouseEvents() {
        view.getRoot().setOnMousePressed(e -> {
            startX = e.getX();
            startY = e.getY();

            currentRect = new Rectangle();
            currentRect.setX(startX);
            currentRect.setY(startY);
            currentRect.setStroke(Color.RED);
            currentRect.setFill(Color.TRANSPARENT);
            currentRect.setStrokeWidth(2);

            view.getRoot().getChildren().add(currentRect);
        });

        view.getRoot().setOnMouseDragged(e -> {
            double width = e.getX() - startX;
            double height = e.getY() - startY;

            currentRect.setWidth(Math.abs(width));
            currentRect.setHeight(Math.abs(height));

            if (width < 0) currentRect.setX(e.getX());
            if (height < 0) currentRect.setY(e.getY());
        });

        view.getRoot().setOnMouseReleased(e -> {
            JsonSave.saveRectangle(imageName, currentRect, view.getImage());
        });
    }
}
