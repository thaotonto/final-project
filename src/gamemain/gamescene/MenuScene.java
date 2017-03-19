package gamemain.gamescene;

import gamemain.NotificationCenter;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;


import static gamemain.Game.FRAME_HEIGHT;
import static gamemain.Game.FRAME_WIDTH;

/**
 * Created by EDGY on 3/19/2017.
 */
public class MenuScene implements GameScene{
    @Override
    public void run() {

    }

    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(Utils.loadImageFromres("BackGroundStartGame.png"),0,0,FRAME_WIDTH,FRAME_HEIGHT,null);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Z){
            NotificationCenter.getInstance().onChange(SceneType.PLAY_SCENE,true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
