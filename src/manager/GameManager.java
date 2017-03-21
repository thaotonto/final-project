package manager;

import controllers.BulletController1;
import controllers.GameController;
import controllers.PlayerController1;
import controllers.PlayerController2;
import gamemain.Game;

import java.awt.*;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Vector;

import static gamemain.Main.gameFrame;
import static gamemain.gamescene.PlayScene.playerWin;

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
        ObjectManager.addObject(gameControllers);
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

        checkCollide();

        //xóa đối tượng đi ra ngoài màn
        clearOutScreen();
    }

    public boolean changeTurn() {
        for (int i = 0; i < gameControllers.size(); i++) {
            if (gameControllers.get(i) instanceof BulletController1) {
                return false;
            }
        }
        return true;
    }

    // Vẽ các đối tượng
    public void draw(Graphics2D g) {
        // vẽ Background
        for (GameController controller : backGrounds) {
            controller.draw(g);
        }

        // vẽ các đối tượng throng game
        for (int i = 0; i < gameControllers.size(); i++) {
            if (gameControllers.get(i).isActive())
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

            if (!controller.getModel().isAlive()) {
                if (controller instanceof PlayerController1) {
//                    gameFrame.setGameOver(1);
                    playerWin = 2;
                }
                if (controller instanceof PlayerController2) {
//                    gameFrame.setGameOver(2);
                    playerWin = 1;
                }
                iterator.remove();
            }
        }
    }

    public void checkCollide() {
        for (int i = 0; i < gameControllers.size() - 1; i++) {
            for (int j = i + 1; j < gameControllers.size(); j++) {
                GameController gi = gameControllers.get(i);
                GameController gj = gameControllers.get(j);
//                if (gj.isActive() && gj.isActive())
                if (gi.checkContact(gj)) {
                    gi.onContact(gj);
                    gj.onContact(gi);
                }
            }
        }
    }
}
