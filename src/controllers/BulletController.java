package controllers;

import models.BulletModel;
import models.GameModel;
import utils.Utils;
import views.BulletView;
import views.GameView;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletController extends GameController {
    public BulletController(BulletModel model, BulletView view) {
        super(model, view);
    }

    public BulletController (int x, int y){
        this(new BulletModel(x,y,BulletModel.DEFAULT_WIDTH, BulletModel.DEFAULT_HEIGHT),
                new BulletView(Utils.loadImageFromres("bullet-1-0.png")));
    }
}
