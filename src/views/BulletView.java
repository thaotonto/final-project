package views;

import gamemain.Game;
import models.GameModel;
import utils.Utils;

import java.awt.*;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletView extends GameView {
    private Animation BulletPlayer1;
    private Animation BulletPlayer2;

    public static final int TIME_CHANGE_IMAGE = 20*Game.GAME_LOOP_TIME;
    private int timeCount= 0;
    private int indexImage = 0;
    public BulletView(Image image) {
        super(image);
        BulletPlayer1 = new Animation(98, Utils.getlistURLImage("/chickenLeft/chickenLeft" , 9));
        BulletPlayer2 = new Animation(98, Utils.getlistURLImage("/chickenRight/chickenRight",9));
    }

    public void explodeShot(int i) {
        // i la player 1 or player 2
        if(i==1){
            image = BulletPlayer1.getImageFree();
        } else if(i==2){
             image = BulletPlayer2.getImageFree();
        }
    }

    @Override
    public void draw(Graphics2D graphics, GameModel model) {
        super.draw(graphics, model);
    }
}
