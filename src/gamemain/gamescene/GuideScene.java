package gamemain.gamescene;

import gamemain.NotificationCenter;
import utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static gamemain.Game.FRAME_HEIGHT;
import static gamemain.Game.FRAME_WIDTH;

/**
 * Created by EDGY on 3/25/2017.
 */
public class GuideScene implements GameScene {

    private static final int WIDTH = 250;
    private static final int HEIGHT = 100;
    private static final int x = 408;
    private static final int y = 496;
    private Rectangle start;

    public GuideScene() {
        start = new Rectangle(x,y,WIDTH,HEIGHT);
        MenuScene.clip = Utils.playSound("resources/go.wav",true);

    }

    @Override
    public void run() {

    }

    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(Utils.loadImageFromres("GuideBG.png"), 0, 0, FRAME_WIDTH, FRAME_HEIGHT, null);
        graphics.drawImage(Utils.loadImageFromres("Go.png"),x,y,WIDTH,HEIGHT,null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            MenuScene.clip.stop();
            NotificationCenter.getInstance().onChange(SceneType.PLAY_SCENE, true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        if(start.contains(p)){
            MenuScene.clip.stop();
            NotificationCenter.getInstance().onChange(SceneType.PLAY_SCENE, true);
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
