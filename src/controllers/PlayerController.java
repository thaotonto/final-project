package controllers;

import models.GameModel;
import models.PlayerModel;
import utils.Utils;
import views.GameView;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerController extends GameController {
    public PlayerController(GameModel model, GameView view) {
        super(model, view);
    }

    public PlayerController(int x, int y, String iconPath) {
        this(new GameModel(x,y, PlayerModel.DEFAULT_WIDTH, PlayerModel.DEFAULT_HEGHT),
                new GameView(Utils.loadImageFromres(iconPath)));
    }
}
