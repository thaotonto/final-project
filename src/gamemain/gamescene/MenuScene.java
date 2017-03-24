package gamemain.gamescene;

import gamemain.NotificationCenter;
import utils.Utils;


import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


import static gamemain.Game.FRAME_HEIGHT;
import static gamemain.Game.FRAME_WIDTH;

/**
 * Created by EDGY on 3/19/2017.
 */
public class MenuScene implements GameScene{
    private Image startImage = Utils.loadImageFromres("startGame.png");
    private Image quitImage = Utils.loadImageFromres("quitgame.png");
    private Rectangle start;
    private Rectangle quit;

    public MenuScene() {
        start = new Rectangle(FRAME_WIDTH / 2 - 350 / 2 , FRAME_HEIGHT / 2 - 100 / 2 ,350,100);
        quit = new Rectangle(FRAME_WIDTH / 2 - 350 / 2 , FRAME_HEIGHT / 2 + 100  ,350,100);
    }

    @Override
    public void run() {

    }

    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(Utils.loadImageFromres("BackGroundStartGame.png"),0,0,FRAME_WIDTH,FRAME_HEIGHT,null);
        graphics.drawImage(startImage,FRAME_WIDTH / 2 - 350 / 2 , FRAME_HEIGHT / 2 - 100 / 2 ,350,100,null);
        graphics.drawImage(quitImage,FRAME_WIDTH / 2 - 350 / 2 , FRAME_HEIGHT / 2 + 100  ,350,100,null);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        if (start.contains(p)) {
            NotificationCenter.getInstance().onChange(SceneType.GUIDE_SCENE, true);
        }
        if (quit.contains(p)) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
