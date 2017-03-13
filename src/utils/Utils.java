package utils;

import models.GameModel;
import models.ObjectModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class Utils {
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
        int x_tam = obj.getMidX();
        int y_tam = obj.getMidY();

        Rectangle rectangle = model.getRect();

        int x_model_top_left = (int)rectangle.getX();
        int y_model_top_left = (int)rectangle.getY();

        int x_model_top_right = (int) (rectangle.getX()+rectangle.getWidth());
        int y_model_top_right = (int)rectangle.getY();

        int x_model_bot_right = (int) (rectangle.getX()+rectangle.getWidth());
        int y_model_bot_right = (int) (rectangle.getY()+rectangle.getHeight());

        int x_model_bot_left = (int) (rectangle.getX());
        int y_model_bot_left = (int) (rectangle.getY()+rectangle.getHeight());

        if(checkFar(x_tam, y_tam, x_model_top_left, y_model_top_left,ObjectModel.DEFAULT_WIDTH/2)){
            return true;
        }

        if(checkFar(x_tam, y_tam, x_model_top_right, y_model_top_right,ObjectModel.DEFAULT_WIDTH/2)){
            return true;
        }

        if(checkFar(x_tam, y_tam, x_model_bot_right, y_model_bot_right,ObjectModel.DEFAULT_WIDTH/2)){
            return true;
        }

        if(checkFar(x_tam, y_tam, x_model_bot_left, y_model_bot_left,ObjectModel.DEFAULT_WIDTH/2)){
            return true;
        }

        return false;

    }

    public static boolean checkFar(int x_tam,int y_tam, int x_model_top_left, int y_model_top_left, int R) {
        int width = x_model_top_left-x_tam;
        int height = y_model_top_left-y_tam;

        int far = (int)Math.sqrt(width*width+height*height);
        if(far<=R){
            return true;
        }else {
            return false;
        }
    }

}
