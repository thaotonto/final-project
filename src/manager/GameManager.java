package manager;

import controllers.GameController;
import gamemain.Game;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */

// Quản lí các đối tượng trong game
public class GameManager {
    Vector<GameController> gameControllers;
    Vector<GameController> backGrounds;

    public GameManager() {
        this.gameControllers = new Vector<>();
        this.backGrounds = new Vector<>();

        BackGroundManager.addBackground(backGrounds);
        PlayerManger.addPlayer(gameControllers);
    }

    // Chạy run của tất cả cá đối tượng
    public void run(){
        // chạy Background
        for (GameController controller : backGrounds){
            controller.run();
        }

        // Chạy các đối tượng khác
        for(GameController controller : gameControllers){
            controller.run();
        }

        //xóa đối tượng đi ra ngoài màn
        clearOutScreen();
    }

    // Vẽ các đối tượng
    public void draw(Graphics2D g){
        // vẽ Background
        for (GameController controller : backGrounds){
            controller.draw(g);
        }

        // vẽ các đối tượng throng game
        for(GameController controller : gameControllers){
            controller.draw(g);
        }
    }

    // Loại các đối tượng ra khỏi map
    public void clearOutScreen(){
        Iterator<GameController> iterator = gameControllers.iterator();
        while (iterator.hasNext()){
            GameController controller = iterator.next();
            if(controller.getModel().getX()<(0-controller.getModel().getWidth())
                    || controller.getModel().getX()>(Game.FRAME_WIDTH+controller.getModel().getWidth())
                    || controller.getModel().getY()<(0-controller.getModel().getHeight())
                    || controller.getModel().getY()>(Game.FRAME_HEIGHT+controller.getModel().getHeight())){
                iterator.remove();
                System.out.println("ok");
            }
        }
    }
}
