package manager;

import controllers.GameController;
import controllers.PlayerController1;
import controllers.PlayerController2;
import controllers.PlayerInforController;
import gamemain.Game;
import models.PlayerInforModel;
import models.PlayerModel;

import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerManger {
    public static void  addPlayer(Vector<GameController> gameControllers, BitSet bitSet1, BitSet bitSet2){
        PlayerController1 playerController1 = new PlayerController1(50, Game.FRAME_HEIGHT-250, bitSet1,gameControllers,"ninja-left/ninja-hit/ninja-hit11.png");
        PlayerController2 playerController2 = new PlayerController2(Game.FRAME_WIDTH-130, Game.FRAME_HEIGHT-270,bitSet2,gameControllers,"ninja-right/ninja-hit/ninja-hit11.png");
        gameControllers.add(playerController1);
        gameControllers.add(playerController2);

        PlayerInforController playerInforController1 = new PlayerInforController(0+ 20, 40, (PlayerModel) playerController1.getModel());
        PlayerInforController playerInforController2 = new PlayerInforController(Game.FRAME_WIDTH - PlayerInforModel.DEFAULT_WIDTH-20, 40, (PlayerModel) playerController2.getModel());
        gameControllers.add(playerInforController1);
        gameControllers.add(playerInforController2);
    }
}
