package gamemain.gamescene;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by EDGY on 3/19/2017.
 */
public interface GameScene extends KeyListener{
    void run();
    void update(Graphics graphics);
}
