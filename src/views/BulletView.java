package views;

import gamemain.Game;
import models.GameModel;
import utils.Utils;

import java.awt.*;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletView extends GameView {
    public static final int TIME_CHANGE_IMAGE = 20*Game.GAME_LOOP_TIME;
    private int timeCount= 0;
    private int indexImage = 0;
    public BulletView(Image image) {
        super(image);
    }
    public void changeImage(){
        timeCount +=Game.GAME_LOOP_TIME;
        if(timeCount >= TIME_CHANGE_IMAGE){
            timeCount = 0;
            if(indexImage<=1){
                indexImage++;
            }else {
                indexImage = 0;
            }
            image = Utils.loadImageFromres("bullet-1-"+indexImage+".png");
        }
    }

    @Override
    public void draw(Graphics2D graphics, GameModel model) {
        super.draw(graphics, model);
    }
}
