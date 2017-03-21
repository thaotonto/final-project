package gamemain.gamescene;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

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
    @Override
    public void run() {

    }

    @Override
    public void update(Graphics graphics) {
        Image imageBG = Utils.loadImageFromres("BG.png");
        graphics.drawImage(imageBG, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, null);
        if(playerWin == 1){
            image = Utils.loadImageFromres("player-1-wins.png");
        }
        if(playerWin == 2)
        {
            image = Utils.loadImageFromres("player-2-wins.png");
        }
        playerWin = 0;
        graphics.drawImage(this.image, (FRAME_WIDTH / 2 - width / 2), (FRAME_HEIGHT / 2 - height / 2), width, height, null);
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
}
