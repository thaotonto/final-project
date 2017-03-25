package controllers;

import models.GameModel;
import models.ItemModel;
import views.GameView;
import views.ItemView;

import java.awt.*;

/**
 * Created by EDGY on 3/24/2017.
 */
public class ItemController extends GameController {
    private static final int TIME_ALIVE = 5000;
    private int timeAlive = 0;
    public ItemController(GameModel model, GameView view) {
        super(model, view);
    }

    public ItemController(int x, int y,Image image){
        this(new ItemModel(x,y),
                new ItemView(image));
    }

    @Override
    public void onContact(GameController other) {
        if(other instanceof BulletController1 || other instanceof BulletController2){
           this.model.setAlive(false);
           other.getModel().setAlive(false);
        }

    }

    @Override
    public void run() {
        timeAlive++;
        if(timeAlive == TIME_ALIVE){
            this.getModel().setAlive(false);
        }
    }
}
