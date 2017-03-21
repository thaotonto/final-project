package controllers;

import models.PlayerInforModel;
import models.PlayerModel;
import views.GameView;
import views.PlayerInforView;

import java.awt.*;

/**
 * Created by TrKaJv on 22-Mar-17.
 */
public class PlayerInforController extends GameController {

    public PlayerInforController(PlayerInforModel model, PlayerInforView view) {
        super(model, view);
    }

    public PlayerInforController(int x, int y, PlayerModel model) {
        this(new PlayerInforModel(x,y,PlayerInforModel.DEFAULT_WIDTH,PlayerInforModel.DEFAULT_HEIGHT,model),
                new PlayerInforView(null));
    }

    public void run(){

    }

    public void draw(Graphics2D graphics){
        view.draw(graphics, model);
    }
}
