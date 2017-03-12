package manager;

import controllers.BulletController;
import controllers.GameController;
import gamemain.Game;
import models.PlayerModel1;
import models.PlayerModel2;

import java.awt.*;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */

// Quản lí các đối tượng trong game
public class GameManager {
    boolean check = false;
    BitSet bitSet1;
    BitSet bitSet2;
    Vector<GameController> gameControllers;
    Vector<GameController> backGrounds;

    public GameManager(BitSet bitSet1, BitSet bitSet2, int turn) {
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

        if (changeTurn() == true && check == true) {
            check = false;
            Game.turn = 3 - Game.turn;
            if(Game.turn ==1){
                PlayerModel1.resetShoot();
            }else {
                PlayerModel2.resetShoot();
            }
            bitSet1.clear();
            bitSet2.clear();
        }
        System.out.println(Game.turn);
    }

    public boolean changeTurn() {
        for (int i = 0; i < gameControllers.size(); i++) {
            if (gameControllers.get(i) instanceof BulletController) {
                check = true;
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
        }
    }

    public void checkCollide() {
        for (int i = 0; i < gameControllers.size() - 1; i++) {
            for (int j = i + 1; j < gameControllers.size(); j++) {
                GameController gi = gameControllers.get(i);
                GameController gj = gameControllers.get(j);
                if (gj.isActive() && gj.isActive())
                    if (gi.checkContact(gj)) {
                        gi.onContact(gj);
                        gj.onContact(gi);
                    }
            }
        }
    }
}
