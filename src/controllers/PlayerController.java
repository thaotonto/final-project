package controllers;

import begavior.move.MoveBehavior;
import gamemain.Game;
import models.GameModel;
import models.PlayerModel;
import utils.Utils;
import views.GameView;
import views.PlayerView;

import java.awt.*;
import java.util.BitSet;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerController extends GameController {
    // Đảo nó đứng
    GameController island;

    public PlayerController(PlayerModel model, PlayerView view) {
        super(model, view);
        Image island = Utils.loadImageFromres("BG-1-3.png");
        this.island = new GameController(new GameModel(
                model.getX() + (model.getWidth() - island.getWidth(null)) / 2,
                model.getY() + model.getHeight() - 20,
                island.getWidth(null),
                island.getHeight(null)),
                new GameView(island));
    }

    public PlayerController(int x, int y, BitSet bitSet, String iconPath) {
        this(new PlayerModel(x, y, PlayerModel.DEFAULT_WIDTH, PlayerModel.DEFAULT_HEGHT, bitSet),
                new PlayerView(Utils.loadImageFromres(iconPath)));
    }

    @Override
    public void run() {
        if (model instanceof PlayerModel) {
            ((PlayerModel) model).run();
        }
        // Set vị trí đảo theo vị trí nó
        island.getModel().setX(model.getX() + (model.getWidth() - island.getModel().getWidth()) / 2);
        island.getModel().setY(model.getY() + model.getHeight() - 20);
    }

    @Override
    public void draw(Graphics2D graphics) {
        // Vẽ đảo
        island.draw(graphics);
        super.draw(graphics);
    }
}
