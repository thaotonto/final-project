package gamemain;

import manager.GameManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.BitSet;
import java.awt.event.KeyListener;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class Game extends JPanel implements Runnable, KeyListener {

    public static final int GAME_LOOP_TIME = 17;
    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 600;
    public static int win = 0;

    // Biến
    Thread loop;
    private BitSet bitSet1; // Lưu lại các hành động khi chơi game
    private BitSet bitSet2;
    GameManager gameManager; // Các đối tượng trong game các hành động
    private BufferedImage backImage;

    public Game() {
        addKeyListener(this);
        setFocusable(true);
        // Thêm và khởi tạo các object abn đầu
        addObjectInit();
        // Thêm các event về phím và tắt màn hình
        addKeyListener(this);
        //loop game
        loop.start();
    }


    // Khởi tạo các đối tượng ban đầu
    private void addObjectInit() {
        bitSet1 = new BitSet(256);  // Khởi tạo bitset
        bitSet2 = new BitSet(256);  // Khởi tạo bitset

        gameManager = new GameManager(bitSet1, bitSet2);   //Khởi tạo gameManager
        backImage = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        loop = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    gameManager.run();
                    repaint();
                    try {
                        Thread.sleep(GAME_LOOP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        super.paintComponent(graphics);
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
            if (e.getKeyCode() == KeyEvent.VK_W
                    || e.getKeyCode() == KeyEvent.VK_S
                    || e.getKeyCode() == KeyEvent.VK_A
                    || e.getKeyCode() == KeyEvent.VK_D
                    || e.getKeyCode() == KeyEvent.VK_SPACE) {
                bitSet1.set(e.getKeyCode());
            } else if (e.getKeyCode() == KeyEvent.VK_UP
                    || e.getKeyCode() == KeyEvent.VK_DOWN
                    || e.getKeyCode() == KeyEvent.VK_LEFT
                    || e.getKeyCode() == KeyEvent.VK_RIGHT
                    || e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
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
    public void run() {

    }

}
