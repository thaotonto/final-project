package manager;

import controllers.GameController;
import gamemain.Game;

import java.awt.*;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */

// Quản lí các đối tượng trong game
public class GameManager {
    BitSet bitSet1;
    BitSet bitSet2;
    Vector<GameController> gameControllers;
    Vector<GameController> backGrounds;

    public GameManager(BitSet bitSet1, BitSet bitSet2) {
        this.gameControllers = new Vector<>();
        this.backGrounds = new Vector<>();
        this.bitSet1 = bitSet1;
        this.bitSet2 = bitSet2;

        BackGroundManager.addBackground(backGrounds);
        PlayerManger.addPlayer(gameControllers, bitSet1, bitSet2);
    }

    // Chạy run của tất cả cá đối tượng
    public void run() {
        // chạy Background
        for (GameController controller : backGrounds) {
            controller.run();
        }

        // Chạy các đối tượng khác
        for (int i = 0; i < gameControllers.size(); i++) {
            gameControllers.get(i).run();
        }

        //xóa đối tượng đi ra ngoài màn
        clearOutScreen();
    }

    // Vẽ các đối tượng
    public void draw(Graphics2D g) {
        // vẽ Background
        for (GameController controller : backGrounds) {
            controller.draw(g);
        }

        // vẽ các đối tượng throng game
        for (int i = 0; i < gameControllers.size(); i++) {
            gameControllers.get(i).draw(g);
        }
    }

    // Loại các đối tượng ra khỏi map
    public void clearOutScreen() {
        Iterator<GameController> iterator = gameControllers.iterator();
        while (iterator.hasNext()) {
            GameController controller = iterator.next();
            if (controller.getModel().getX() < (0 - controller.getModel().getWidth())
                    || controller.getModel().getX() > (Game.FRAME_WIDTH + controller.getModel().getWidth())
                    || controller.getModel().getY() < (0 - controller.getModel().getHeight())
                    || controller.getModel().getY() > (Game.FRAME_HEIGHT + controller.getModel().getHeight())) {
                iterator.remove();
            }
        }
    }
}
