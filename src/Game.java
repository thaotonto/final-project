
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.BitSet;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class Game extends Frame {

    // Biến
    BitSet bitSet ; // Lưu lại các hành động khi chơi game


    public Game() {
        // Bỏ nút - , vuông , x góc trên bên phải của màn hình
        setUndecorated(true);
        // Set full màn hình
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Cho ra giữa màn
        setLocationRelativeTo(null);

        setVisible(true);
        setSize(1366, 768);

        // Thêm và khởi tạo các object abn đầu
        addObjectInit();
        // Thêm các event về phím và tắt màn hình
        addEvents();
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
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.exit(0);
                } else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    // Pause
                }else {
                    // Phím điều khiển khi chơi game
                    bitSet.set(e.getKeyCode());
                }
            }
        });
    }

    // Khởi tạo các đối tượng ban đầu
    private void addObjectInit() {
        // Khởi tạo bitset
        bitSet = new BitSet(256);
    }

}
