package utils;

import models.BulletModel;
import models.GameModel;
import models.ObjectModel;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Delayed;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class Utils {
    public static ArrayList<String> getlistURLImage(String url, int number) {
        ArrayList<String> listString = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            listString.add(url + (i + 1) + ".png");
        }
        return listString;
    }

    public static Image loadImageFromres(String url) {
        try {
            Image image = ImageIO.read(new File("resources/" + url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkContactWithCircle(GameModel model, ObjectModel obj) {
        if (model instanceof BulletModel) {
            if (obj.equals(((BulletModel) model).getObjContact())) {
                return false;
            }
        }
        int x_tam = obj.getMidX();
        int y_tam = obj.getMidY();

        Rectangle rectangle = model.getRect();

        int x_model_top_left = (int) rectangle.getX();
        int y_model_top_left = (int) rectangle.getY();

        int x_model_top_right = (int) (rectangle.getX() + rectangle.getWidth());
        int y_model_top_right = (int) rectangle.getY();

        int x_model_bot_right = (int) (rectangle.getX() + rectangle.getWidth());
        int y_model_bot_right = (int) (rectangle.getY() + rectangle.getHeight());

        int x_model_bot_left = (int) (rectangle.getX());
        int y_model_bot_left = (int) (rectangle.getY() + rectangle.getHeight());

        if (checkFar(x_tam, y_tam, x_model_top_left, y_model_top_left, ObjectModel.DEFAULT_WIDTH / 2)) {
            return true;
        }

        if (checkFar(x_tam, y_tam, x_model_top_right, y_model_top_right, ObjectModel.DEFAULT_WIDTH / 2)) {
            return true;
        }

        if (checkFar(x_tam, y_tam, x_model_bot_right, y_model_bot_right, ObjectModel.DEFAULT_WIDTH / 2)) {
            return true;
        }

        if (checkFar(x_tam, y_tam, x_model_bot_left, y_model_bot_left, ObjectModel.DEFAULT_WIDTH / 2)) {
            return true;
        }

        return false;

    }

    public static boolean checkFar(int x_tam, int y_tam, int x_model_top_left, int y_model_top_left, int R) {
        int width = x_model_top_left - x_tam;
        int height = y_model_top_left - y_tam;

        int far = (int) Math.sqrt(width * width + height * height);
        if (far <= R) {
            return true;
        } else {
            return false;
        }
    }


    public static float[] findSpeed(ObjectModel model, float x1, float y1, float x2, float y2) {
        float x_o = model.getMidX();
        float y_o = model.getMidY();

        // Chỉ phương tam - 1
        float n1 = x1 - x_o;
        float n2 = y1 - y_o;

        float t_1_a = (-n2);
        float t_1_b = (n1);
        float t_1_c = -(n1 * y_o) + (n2 * x_o);

        float t_2_a = (n1);
        float t_2_b = (n2);
        float t_2_c = -(n1 * x2) - (n2 * y2);

        float xy_f[] = ghpt(t_1_a, t_1_b, t_1_c,
                t_2_a, t_2_b, t_2_c);
        float x_f = xy_f[0];
        float y_f = xy_f[1];

        float x_next = (x_f - x2) + x_f;
        float y_next = (y_f - y2) + y_f;

        float speedX = x_next - x1;
        float speedY = y_next - y1;

        float[] ok = {speedX, speedY};
        return ok;
    }

    public static float[] ghpt(float a1, float b1, float c1,
                               float a2, float b2, float c2) {
        float y_tu = -c2 + ((a2 * c1) / a1);
        float y_mau = b2 + ((b1 * (-a2)) / a1);

        float y_f = y_tu / y_mau;
        float x_f = (-c1 - b1 * (y_f)) / a1;
        float[] ok = {x_f, y_f};
        return ok;
    }

    public static Clip playSound(String audioUrl, boolean repeat) {
        Clip clip = null;
        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            if (repeat) {
                clip.loop(clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        return clip;
    }
}
