package controllers;

import gamemain.Game;
import models.GameModel;
import models.PlayerModel;
import utils.Utils;
import views.GameView;

import java.awt.*;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerController extends GameController {
    // Đảo nó đứng
    GameController island;

    public PlayerController(GameModel model, GameView view) {
        super(model, view);
        Image island =Utils.loadImageFromres("BG-1-3.png");
        this.island = new GameController(new GameModel(
                model.getX()+(model.getWidth()-island.getWidth(null))/2,
                model.getY()+model.getHeight()-20,
                island.getWidth(null),
                island.getHeight(null)),
                new GameView(island));
    }

    public PlayerController(int x, int y, String iconPath) {
        this(new GameModel(x,y, PlayerModel.DEFAULT_WIDTH, PlayerModel.DEFAULT_HEGHT),
                new GameView(Utils.loadImageFromres(iconPath)));
    }

    @Override
    public void run() {
        super.run();
        // Set vị trí đảo theo vị trí nó
        island.getModel().setX(model.getX()+(model.getWidth()-island.getModel().getWidth())/2);
        island.getModel().setY(model.getY()+model.getHeight()-20);
    }

    @Override
    public void draw(Graphics2D graphics) {
        // Vẽ đảo
        island.draw(graphics);
        super.draw(graphics);
    }
}
