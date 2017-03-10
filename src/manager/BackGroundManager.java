package manager;

import controllers.GameController;
import gamemain.Game;
import models.GameModel;
import utils.Utils;
import views.GameView;

import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class BackGroundManager {
    public static void addBackground(Vector<GameController> gameControllers){
        GameController controller = new GameController(new GameModel(0,0, Game.FRAME_WIDTH, Game.FRAME_HEIGHT),
                new GameView(Utils.loadImageFromres("BG.png")));
        gameControllers.add(controller);
    }
}
