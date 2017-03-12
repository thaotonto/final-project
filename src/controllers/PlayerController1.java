package controllers;

import models.BulletModel;
import models.GameModel;
import models.PlayerModel1;
import utils.Utils;
import views.CharacterView;
import views.GameView;
import views.PlayerView1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerController1 extends GameController {
    // Đảo nó đứng
    GameController island;
    private  boolean checkShootSpace = false;

    public PlayerController1(GameModel model, CharacterView view) {
        super(model, view);
    }

    public PlayerController1(PlayerModel1 model, PlayerView1 view) {
        super(model, view);
        Image island = Utils.loadImageFromres("BG-1-3.png");
        this.island = new GameController(new GameModel(
                (int) model.getX() + (model.getWidth() - island.getWidth(null)) / 2,
                (int) model.getY() + model.getHeight() - 20,
                island.getWidth(null),
                island.getHeight(null)),
                new GameView(island));
    }

    public PlayerController1(int x, int y, BitSet bitSet, Vector<GameController> bullet, String iconPath) {
        this(new PlayerModel1(x, y, PlayerModel1.DEFAULT_WIDTH, PlayerModel1.DEFAULT_HEGHT, bitSet, bullet),
                new CharacterView(Utils.loadImageFromres(iconPath)));
        Image island = Utils.loadImageFromres("BG-1-3.png");
        this.island = new GameController(new GameModel(
                (int) model.getX() + (model.getWidth() - island.getWidth(null)) / 2,
                (int) model.getY() + model.getHeight() - 20,
                island.getWidth(null),
                island.getHeight(null)),
                new GameView(island));
    }

    @Override
    public void run() {
        if (model instanceof PlayerModel1) {
            ((PlayerModel1) model).run();
        }
        if(((PlayerModel1)model).getBitSet().get(KeyEvent.VK_SPACE)){
            checkShootSpace = true;
        }
        if(checkShootSpace){
            if(!((CharacterView)view).explodeStartShot(1)){
                checkShootSpace = false;
            }
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
            if (other.model instanceof BulletModel)
            model.getHit( ((BulletModel) other.model).getDamage() );
        }
    }
}
