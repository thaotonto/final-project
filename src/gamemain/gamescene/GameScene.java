package gamemain.gamescene;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by EDGY on 3/19/2017.
 */
public interface GameScene extends  MouseListener , KeyListener {
    void run();
    void update(Graphics graphics);
}
