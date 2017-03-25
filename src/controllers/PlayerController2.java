package controllers;

import gamemain.gamescene.PlayScene;
import models.*;
import utils.Utils;
import views.CharacterView;
import views.GameView;
import views.PlayerView2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Vector;

import static gamemain.gamescene.PlayScene.playerWin;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerController2 extends GameController {
    // Đảo nó đứng
    GameController island;
    // checkShoot kiem tra no có bắn ko
    private boolean checkShoot = false;
    // checkGetHit kiểm tra nó có bị dính đạn ko
    boolean checkGetHit = false;

    public PlayerController2(GameModel model, CharacterView view) {
        super(model, view);
    }

    public PlayerController2(PlayerModel2 model, PlayerView2 view) {
        super(model, view);
        Image island = Utils.loadImageFromres("BG-1-3.png");
        this.island = new GameController(new GameModel(
                (int) model.getX() + (model.getWidth() - island.getWidth(null)) / 2,
                (int) model.getY() + model.getHeight() - 20,
                island.getWidth(null),
                island.getHeight(null)),
                new GameView(island));
    }

    public PlayerController2(int x, int y, BitSet bitSet, Vector<GameController> bullet, String iconPath) {
        this(PlayerModel2.getInstance(x,y,bitSet,bullet),
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
        if (model instanceof PlayerModel2) {
            ((PlayerModel2) model).run();
        }
        if (((PlayerModel2) model).getBitSet().get(PlayScene.SHOOT_P2)) {
            checkShoot = true;
        }
        // neu no bắn thi get animation bắn
        if (checkShoot) {
            if (!((CharacterView) view).explodeShot(2)) {
                checkShoot = false;
            }
        }
        // neu no trúng đạn thi get animation trung dan
        if (checkGetHit) {

            if (!((CharacterView) view).explodeGetHit(2)) {
                checkGetHit = false;
            }
        }
        // neu no die get animation die
        // check die
       /* if (!model.isAlive()) {
            if (((CharacterView) view).explodeDie(2) == null) {
                // viet code chuyen man choi o day
            }
            }
        */


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

        if (other instanceof BulletController1) {

            if (other.model instanceof BulletModel1) {
                // neu no trung dan thi checkGetHit la False ,trung dan
                checkGetHit = true;
                model.getHit();

                // Tao ra vu no
                ExplodeCotroller explodeCotroller = new ExplodeCotroller((int)other.model.getX(), (int)other.model.getY());
                ((PlayerModel)model).getBullet().add(explodeCotroller);
            }
        }
    }
}
