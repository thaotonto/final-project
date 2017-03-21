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
    private static final String message = "PRESS ANY KEY TO PLAY";
    @Override
    public void run() {

    }

    @Override
    public void update(Graphics graphics) {
        BasicStroke basicStroke = new BasicStroke(1,BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
        ((Graphics2D)graphics).setStroke(basicStroke);
        graphics.setFont(new java.awt.Font("Britannic",1, 23));
        graphics.setColor(new Color(13, 23, 255));

        graphics.drawImage(Utils.loadImageFromres("BackGroundStartGame.png"),0,0,FRAME_WIDTH,FRAME_HEIGHT,null);
        graphics.drawString(message, 450, 500);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() != KeyEvent.VK_ESCAPE){
            NotificationCenter.getInstance().onChange(SceneType.PLAY_SCENE,true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
