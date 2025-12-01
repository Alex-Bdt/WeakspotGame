package game.utils;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class JsonSave {

    private static final String FILE_NAME = "src/main/resources/data/zones.json";
    private static JSONObject jsonData = new JSONObject();

    public static void saveRectangles(Image img, List<Rectangle> rectangles) {
        String imageKey = img.getUrl(); // identifiant unique
        if (imageKey == null) {	//evite d'exploser
            imageKey = "unknown_image";
        }
        
        double imgW = img.getWidth();
        double imgH = img.getHeight();

        JSONArray array = new JSONArray();
        for (Rectangle rect : rectangles) {
            JSONObject zone = new JSONObject();
            zone.put("x", rect.getX() / imgW);
            zone.put("y", rect.getY() / imgH);
            zone.put("width", rect.getWidth() / imgW);
            zone.put("height", rect.getHeight() / imgH);
            array.put(zone);
        }
        jsonData.put(imageKey, array);

        saveToFile();
    }


    private static void saveToFile() {
        try (FileWriter writer = new FileWriter(new File(FILE_NAME))) {
            writer.write(jsonData.toString(4)); // format pretty
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
