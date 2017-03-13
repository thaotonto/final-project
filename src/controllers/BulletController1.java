package controllers;

import models.BulletModel1;
import models.BulletModel2;
import models.ObjectModel;
import utils.Utils;
import views.BulletView;

import java.awt.*;


/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletController1 extends GameController {

    public BulletController1(BulletModel1 model, BulletView view) {
        super(model, view);
    }

    public BulletController1(int x, int y, float angle) {
        this(new BulletModel1(x, y, BulletModel1.DEFAULT_WIDTH, BulletModel1.DEFAULT_HEIGHT, angle),
                new BulletView(Utils.loadImageFromres("bullet-1-0.png")));
    }

    public void onContact(GameController other) {
        if (other instanceof PlayerController1 || other instanceof PlayerController2) {
            active = false;
            other.getModel().getHit(((BulletModel1) model).getDamage());
        }

        if (other instanceof ObjectController) {
            model.setAlive(false);
        }
    }
}
