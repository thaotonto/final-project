package manager;

import controllers.GameController;
import controllers.PlayerController;
import gamemain.Game;

import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerManger {
    public static void  addPlayer(Vector<GameController> gameControllers){
        PlayerController playerController1 = new PlayerController(50, Game.FRAME_HEIGHT-150,"player-2.png");
        PlayerController playerController2 = new PlayerController(Game.FRAME_WIDTH-130, Game.FRAME_HEIGHT-150,"player-1.png");
        gameControllers.add(playerController1);
        gameControllers.add(playerController2);
    }
}
