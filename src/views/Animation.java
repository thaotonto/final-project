package views;

import models.GameModel;
import models.PlayerModel1;
import models.PlayerModel2;
import utils.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by AnhLt on 3/11/2017.
 */
public class Animation {
    private long lastTime;
    private int index=0;
    private int delay;
    private Image image;
    private ArrayList<String> listUrl;

    public Animation( int delay, ArrayList<String> listUrl) {
        this.delay = delay;
        this.delay = delay;
        this.listUrl = listUrl;
    }



    public Image getImage() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime > delay && index <= listUrl.size()) {
            lastTime = currentTime;
            if (index == listUrl.size()) {
                index = 0;
                return null;
            }

            image = Utils.loadImageFromres(listUrl.get(index));
            index++;
        }
        return image;
    }

    public Image getImageFree(){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime > delay && index <= listUrl.size()) {
            lastTime = currentTime;
            if (index == listUrl.size()) {
                index = 0;
                //return null;
            }

            image = Utils.loadImageFromres(listUrl.get(index));
            index++;
        }
        return image;
    }

    public void reload() {
        if (index == listUrl.size()) {
            index = 0;
        }
    }
}
