package manager;

import controllers.GameController;
import controllers.PlayerController1;
import controllers.PlayerController2;
import gamemain.Game;

import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerManger {
    public static void  addPlayer(Vector<GameController> gameControllers, BitSet bitSet1, BitSet bitSet2){
        PlayerController1 playerController11 = new PlayerController1(50, Game.FRAME_HEIGHT-250, bitSet1,gameControllers,"ninja-left/ninja-hit/ninja-hit11.png");
        PlayerController2 playerController12 = new PlayerController2(Game.FRAME_WIDTH-130, Game.FRAME_HEIGHT-270,bitSet2,gameControllers,"ninja-right/ninja-hit/ninja-hit11.png");
        gameControllers.add(playerController11);
        gameControllers.add(playerController12);
    }
}
