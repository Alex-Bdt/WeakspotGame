package game.controllers;

import game.MainFx;
import game.views.MakerView;

public class MainController {

    public void goToMakerView() {
    	MakerView makerView = new MakerView("/pictures/tiger.png", 800, 600);
        MainFx.setScene(makerView.getScene(), "Maker View");
    }
/*
    public void goToB() {
        MainFx.setScene(new ViewB().getScene(), "Scene B");
    }
*/
}
