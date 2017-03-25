package controllers;

import gamemain.Game;
import models.GameModel;
import models.ItemModel;
import models.PlayerModel1;
import models.PlayerModel2;
import views.GameView;
import views.ItemView;

import java.awt.*;

/**
 * Created by EDGY on 3/25/2017.
 */
public class HpItemController extends GameController{

    private int countAlive = 0;
    private static final int ALIVE_TIME = 4000;

    public HpItemController(GameModel model, GameView view) {
        super(model, view);
    }

    public HpItemController(int x, int y, Image image) {
        this(new ItemModel(x,y),
                new ItemView(image));
    }

    @Override
    public void onContact(GameController other) {
        if(other instanceof BulletController1 ){
            PlayerModel1.getInstance().hpRegen();
            other.getModel().setAlive(false);
            this.model.setAlive(false);
        }
        if(other instanceof BulletController2 ){
            PlayerModel2.getInstance().hpRegen();
            other.getModel().setAlive(false);
            this.model.setAlive(false);
        }
    }

    @Override
    public void run() {
        countAlive+= Game.GAME_LOOP_TIME;
        if (countAlive >= ALIVE_TIME) {
            countAlive = 0;
            this.model.setAlive(false);
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);
    }
}
