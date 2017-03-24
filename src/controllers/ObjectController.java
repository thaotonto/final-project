package controllers;

import manager.PlayerManger;
import models.GameModel;
import models.ObjectModel;
import utils.Utils;
import views.GameView;
import views.ObjectView;

/**
 * Created by Thaotonto on 3/12/2017.
 */
public class ObjectController extends GameController {
    public ObjectController(GameModel model, GameView view) {
        super(model, view);
    }

    public ObjectController (int x, int y){
        this(new ObjectModel(x,y,ObjectModel.DEFAULT_WIDTH, ObjectModel.DEFAULT_HEIGHT),
                new ObjectView(Utils.loadImageFromres("round.png")));
    }

    @Override
    public void onContact(GameController other) {
        if (other instanceof BulletController1) {
            if (model.getHp() <=1 ){
                PlayerManger.getInstancePlayer1().getModel().getHit(20);
            }
            model.getHit(1);
        }
        if (other instanceof BulletController2) {
            if (model.getHp() <=1 ){
                PlayerManger.getInstancePlayer2().getModel().getHit(20);
                //lol
            }
            model.getHit(1);
        }
    }

    @Override
    public void run() {
        if (model instanceof ObjectModel) {
            ((ObjectModel) model).run();
        }
    }
}
