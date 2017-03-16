package gamemain;

import manager.GameManager;
import utils.MouseInput;
import views.GameMenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.BitSet;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class Game extends Frame {

    public static final int GAME_LOOP_TIME = 17;
    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 600;
    public static GameMenuView.MenuType menuType;

    // Biến
    Thread loop;
    private BitSet bitSet1; // Lưu lại các hành động khi chơi game
    private BitSet bitSet2;
    GameManager gameManager; // Các đối tượng trong game các hành động
    private BufferedImage backImage;

    public Game() {
        //menu home
        menuType = GameMenuView.MenuType.HOME;
        // Bỏ nút - , vuông , x góc trên bên phải của màn hình
//        setUndecorated(true);
        // Set full màn hình
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        // Cho ra giữa màn
        setLocationRelativeTo(null);

        // Thêm và khởi tạo các object abn đầu
        addObjectInit();
        // Thêm các event về phím và tắt màn hình
        addEvents();
        //loop game
        loop.start();
    }

    // Thêm các event về phím và tắt màn hình
    private void addEvents() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Thoát game
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
//                System.out.println(turn);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                    bitSet1.clear(e.getKeyCode());
                    bitSet2.clear(e.getKeyCode());
            }
        });

        this.addMouseListener(new MouseInput());
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
    public void update(Graphics g) {
        Graphics2D back_g = (Graphics2D) backImage.getGraphics();
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.draw(back_g);
        if(menuType == GameMenuView.MenuType.START){
            gameManager.draw(back_g);
        }

        g.drawImage(backImage, 0, 0, null);
    }
}
