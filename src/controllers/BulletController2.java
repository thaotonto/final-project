package controllers;

import models.BulletModel;
import models.BulletModel1;
import models.BulletModel2;
import models.ObjectModel;
import utils.Utils;
import views.BulletView;


/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletController2 extends GameController {

    public BulletController2(BulletModel2 model, BulletView view) {
        super(model, view);
    }

    public BulletController2(int x, int y, float angle) {
        this(new BulletModel2(x, y, BulletModel1.DEFAULT_WIDTH, BulletModel1.DEFAULT_HEIGHT, angle),
                new BulletView(Utils.loadImageFromres("bullet-2-0.png")));
    }

    public void onContact(GameController other) {
        if (other instanceof PlayerController1) {
            model.setAlive(false);
        }

        if (other instanceof ObjectController) {
            ((BulletModel)model).setContact(true);
            ((BulletModel)model).setObjContact((ObjectModel) other.getModel());
        }
    }
}
