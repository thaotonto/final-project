package views;

import utils.Utils;

import java.awt.*;

/**
 * Created by TrKaJv on 25-Mar-17.
 */
public class ExplodeView extends GameView {
    private Animation ExplodeChicken;
    public ExplodeView(Image image) {
        super(image);
        ExplodeChicken = new Animation(98, Utils.getlistURLImage("explode/explode_" , 5));
    }

    public boolean explodeShot() {
        // chay anh con ga bi no
            Image temp = ExplodeChicken.getImage();
            if (temp != null) {
                image = temp;
                return true;
            }
        return false;
    }
}
