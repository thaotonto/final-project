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

    public GameManager() {
        this.gameControllers = new Vector<>();
    }

    // Chạy run của tất cả cá đối tượng
    public void run(){
        for(GameController controller : gameControllers){
            controller.run();
        }
    }

    // Vẽ các đối tượng
    public void draw(Graphics2D g){
        for(GameController controller : gameControllers){
            controller.draw(g);
        }
    }

    // Loại các đối tượng ra khỏi map
    public void clearOutScreen(){
        Iterator<GameController> iterator = gameControllers.iterator();
        while (iterator.hasNext()){
            GameController controller = iterator.next();
            if(controller.getModel().getX()<(Game.FRAME_WIDTH-controller.getModel().getWidth())
                    || controller.getModel().getX()>(Game.FRAME_WIDTH+controller.getModel().getWidth())
                    || controller.getModel().getY()<(Game.FRAME_HEIGHT-controller.getModel().getHeight())
                    ||controller.getModel().getY()>(Game.FRAME_HEIGHT+controller.getModel().getHeight())){
                iterator.remove();
            }
        }
    }
}
