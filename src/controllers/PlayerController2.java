package controllers;

import models.BulletModel;
import models.GameModel;
import models.PlayerModel1;
import models.PlayerModel2;
import utils.Utils;
import views.GameView;
import views.PlayerView2;

import java.awt.*;
import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerController2 extends GameController {
    // Đảo nó đứng
    GameController island;

    public PlayerController2(PlayerModel2 model, PlayerView2 view) {
        super(model, view);
        Image island = Utils.loadImageFromres("BG-1-3.png");
        this.island = new GameController(new GameModel(
                (int)model.getX() + (model.getWidth() - island.getWidth(null)) / 2,
                (int)model.getY() + model.getHeight() - 20,
                island.getWidth(null),
                island.getHeight(null)),
                new GameView(island));
    }

    public PlayerController2(int x, int y, BitSet bitSet, Vector<GameController> bullet, String iconPath) {
        this(new PlayerModel2(x, y, PlayerModel1.DEFAULT_WIDTH, PlayerModel1.DEFAULT_HEGHT, bitSet, bullet),
                new PlayerView2(Utils.loadImageFromres(iconPath)));
    }

    @Override
    public void run() {
        if (model instanceof PlayerModel2) {
            ((PlayerModel2) model).run();
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

    public void onContact(GameController other) {
        if (other instanceof BulletController) {
            if (other.model instanceof BulletModel) {
                model.getHit(((BulletModel) other.model).getDamage());
            }
        }
    }
}
