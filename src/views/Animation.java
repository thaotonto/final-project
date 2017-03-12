package views;

import models.GameModel;
import models.PlayerModel1;
import models.PlayerModel2;
import utils.Utils;

import java.awt.*;

/**
 * Created by QuanT on 3/11/2017.
 */
public class Animation {
    private long lastTime;
    private int index=0;
    private int size;
    private int delay;
    private Image image;
    private String url;

    public Animation(int size, int delay, String url) {
        this.delay = delay;
        this.delay = delay;
        this.size = size;
        this.url = url;
    }



    public Image getImage() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime > delay && index <= size) {
            lastTime = currentTime;
            if (index == size) {
                index = 0;
                return null;
            }
           index++;
            image = Utils.loadImageFromres(url +index  + ".png");
        }
        return image;
    }

    public void reload() {
        if (index == size) {
            index = 0;
        }
    }
}
