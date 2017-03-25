package controllers;

import gamemain.gamescene.PlayScene;
import models.BulletModel1;
import models.BulletModel2;
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

import static gamemain.gamescene.PlayScene.playerWin;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerController1 extends GameController {
    // Đảo nó đứng
    GameController island;
    // check shoot kiem tra ban hay chua
    boolean checkShoot = false;
    boolean checkAlive = true;
    boolean checkHit = false;

    public boolean isCheckShoot() {
        return checkShoot;
    }

    public void setCheckShoot(boolean checkShoot) {
        this.checkShoot = checkShoot;
    }

    public PlayerController1(GameModel model, CharacterView view) {
        super(model, view);
    }

    public PlayerController1(int x, int y, BitSet bitSet, Vector<GameController> bullet, String iconPath) {
        this(PlayerModel1.getInstance(x,y,bitSet,bullet),
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

        // check ban hay ko va hien animation
        if (((PlayerModel1) model).getBitSet().get(PlayScene.SHOOT_P1)) {
            checkShoot = true;
        }
        if (checkShoot) {
            if (!((CharacterView) view).explodeShot(1)) {
                checkShoot = false;
            }
        }

        if(checkHit){
            if (!((CharacterView) view).explodeGetHit(1)) {
                checkHit = false;
            }
        }

        // check die
        if(!model.isAlive()){
                if(((CharacterView) view).explodeDie(1) == null){
                    // viet code chuyen man choi o day
                }

        }

        // Set vị trí đảo theo vị trí nó
        island.getModel().setX(model.getX() + (model.getWidth() - island.getModel().getWidth()) / 2);
        island.getModel().setY(model.getY() + model.getHeight() - 20);
    }

    @Override
    public void draw(Graphics2D graphics) {
        // Vẽ hp
        // Vẽ đảo
        island.draw(graphics);
        super.draw(graphics);
    }

    public void onContact(GameController other) {
        if (other instanceof BulletController2) {
            if (other.model instanceof BulletModel2) {
                model.getHit();
                checkHit = true;
            }
        }
    }
}
