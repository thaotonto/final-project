package controllers;

import models.BulletModel1;
import models.GameModel;
import models.PlayerModel1;
import models.PlayerModel2;
import utils.Utils;
import views.CharacterView;
import views.GameView;
import views.PlayerView2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerController2 extends GameController {
    // Đảo nó đứng
    GameController island;
    private boolean checkShoot = false;
    boolean checkGetHit = false;

    public PlayerController2(GameModel model, CharacterView view) {
        super(model, view);
    }

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
                new CharacterView(Utils.loadImageFromres(iconPath)));
        Image island = Utils.loadImageFromres("BG-1-3.png");
        this.island = new GameController(new GameModel(
                (int)model.getX() + (model.getWidth() - island.getWidth(null)) / 2,
                (int)model.getY() + model.getHeight() - 20,
                island.getWidth(null),
                island.getHeight(null)),
                new GameView(island));
    }

    @Override
    public void run() {
        if (model instanceof PlayerModel2) {
            ((PlayerModel2) model).run();
        }
        if(((PlayerModel2)model).getBitSet().get(KeyEvent.VK_NUMPAD0)){
            checkShoot = true;
        }
        // neu no ban thi get animation ban
        if(checkShoot){
            if(!((CharacterView)view).explodeShot(2)){
                checkShoot = false;
            }
        }
        // neu no trung dan thi get animation trung dan
        if(checkGetHit){

            if(!((CharacterView)view).explodeGetHit(2)){
                checkGetHit = false;
            }
        }
        // neu no die get animation die
       /* if(model.isAlive()){
            while(((CharacterView)view).explodeDie(2)){

            }

        }*/

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
                model.getHit(((BulletModel1) other.model).getDamage());

            }
        }
    }
}
