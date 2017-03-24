package gamemain.gamescene;

import gamemain.NotificationCenter;
import utils.Utils;


import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static gamemain.Game.FRAME_HEIGHT;
import static gamemain.Game.FRAME_WIDTH;
import static gamemain.gamescene.PlayScene.playerWin;


/**
 * Created by EDGY on 3/19/2017.
 */
public class GameOverScene implements GameScene{
    private Image image;
    private int width = 500;
    private int height = 359;
    private Image menuImage = Utils.loadImageFromres("Menu.png");
    private Image restartImage = Utils.loadImageFromres("Reset.png");
    private Rectangle menu;
    private Rectangle restart;

    public GameOverScene() {
        menu = new Rectangle((FRAME_WIDTH / 2 + width / 8), (FRAME_HEIGHT / 2 + height / 6), 142, 31);
        restart = new Rectangle((FRAME_WIDTH / 2 - width / 3), (FRAME_HEIGHT / 2 + height / 6), 142, 31);
    }

    public void run() {
    }

    @Override
    public void update(Graphics graphics) {
        Image imageBG = Utils.loadImageFromres("BG.png");
        graphics.drawImage(imageBG, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, null);
        if (playerWin == 1) {
            image = Utils.loadImageFromres("player-1-wins-bg.png");
        }
        if (playerWin == 2) {
            image = Utils.loadImageFromres("player-2-wins-bg.png");
        }
        playerWin = 0;
        graphics.drawImage(this.image, (FRAME_WIDTH / 2 - width / 2), (FRAME_HEIGHT / 2 - height / 2), width, height, null);
        graphics.drawImage(this.menuImage, (FRAME_WIDTH / 2 + width / 8), (FRAME_HEIGHT / 2 + height / 6), 142, 31, null);
        graphics.drawImage(this.restartImage, (FRAME_WIDTH / 2 - width / 3), (FRAME_HEIGHT / 2 + height / 6), 142, 31, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        if (menu.contains(p)) {
            MenuScene.clip.stop();
            NotificationCenter.getInstance().onChange(SceneType.MENU_SCENE, false);
        }
        if (restart.contains(p)) {
            MenuScene.clip.stop();
            NotificationCenter.getInstance().onChange(SceneType.PLAY_SCENE, false);
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
