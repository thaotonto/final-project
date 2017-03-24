package gamemain.gamescene;

import controllers.PlayerController1;
import gamemain.NotificationCenter;
import manager.GameManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.BitSet;

/**
 * Created by EDGY on 3/19/2017.
 */
public class PlayScene implements GameScene {
    public static final int UP_P1 = KeyEvent.VK_A;
    public static final int DOWN_P1 = KeyEvent.VK_S;
    public static final int LEFT_P1 = KeyEvent.VK_F;
    public static final int RIGHT_P1 = KeyEvent.VK_H;
    public static final int SHOOT_P1 = KeyEvent.VK_G;
    public static final int UP_P2 = KeyEvent.VK_COMMA;
    public static final int DOWN_P2 = KeyEvent.VK_PERIOD;
    public static final int LEFT_P2 = KeyEvent.VK_RIGHT;
    public static final int RIGHT_P2 = KeyEvent.VK_LEFT;
    public static final int SHOOT_P2 = KeyEvent.VK_DOWN;
    private BitSet bitSet1; // Lưu lại các hành động khi chơi game
    private BitSet bitSet2;
    GameManager gameManager; // Các đối tượng trong game các hành động
    public static int playerWin = 0;

    public PlayScene() {
        bitSet1 = new BitSet(256);  // Khởi tạo bitset
        bitSet2 = new BitSet(256);  // Khởi tạo bitset
        gameManager = new GameManager(bitSet1, bitSet2);   //Khởi tạo gameManager
    }

    @Override
    public void run() {
        gameManager.run();
        if (playerWin != 0) {
            NotificationCenter.getInstance().onChange(SceneType.GAMEOVER_SCENE, false);
        }
    }

    @Override
    public void update(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        gameManager.draw(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // Pause
        } else {
            // Phím điều khiển khi chơi game
            if (e.getKeyCode() == UP_P1
                    || e.getKeyCode() == DOWN_P1
                    || e.getKeyCode() == LEFT_P1
                    || e.getKeyCode() == RIGHT_P1
                    || e.getKeyCode() == SHOOT_P1) {
                bitSet1.set(e.getKeyCode());
            } else if (e.getKeyCode() == UP_P2
                    || e.getKeyCode() == DOWN_P2
                    || e.getKeyCode() == LEFT_P2
                    || e.getKeyCode() == RIGHT_P2
                    || e.getKeyCode() == SHOOT_P2) {
                bitSet2.set(e.getKeyCode());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        bitSet1.clear(e.getKeyCode());
        bitSet2.clear(e.getKeyCode());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
