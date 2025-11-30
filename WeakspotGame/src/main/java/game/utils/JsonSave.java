package game.utils;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;

public class JsonSave {

    private static final String FILE_NAME = "src/main/resources/data/zones.json";
    private static JSONObject jsonData = new JSONObject();

    public static void saveRectangle(String imageName, Rectangle rect, Image img) {

        double imgW = img.getWidth();
        double imgH = img.getHeight();

        JSONObject zone = new JSONObject();
        zone.put("x", rect.getX() / imgW);
        zone.put("y", rect.getY() / imgH);
        zone.put("width", rect.getWidth() / imgW);
        zone.put("height", rect.getHeight() / imgH);

        if (!jsonData.has(imageName)) {
            jsonData.put(imageName, new JSONArray());
        }

        jsonData.getJSONArray(imageName).put(zone);

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
