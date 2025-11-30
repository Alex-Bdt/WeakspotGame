package game.model;

import java.util.List;

public class Tank {
	
	private String name;
    private List<Weakspot> weakspots;
	
    public Tank(String name) {
    	this.name = name;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Le getter qui renvoie le chemin complet pour JavaFX
    public String getImage() {
        // "/pictures/" correspond au dossier resources/pictures
        return "/pictures/" + name + ".png";
    }

    public List<Weakspot> getWeakspots() {
        return weakspots;
    }

    public void setWeakspots(List<Weakspot> weakspots) {
        this.weakspots = weakspots;
    }

}
