package manager;

import behavior.move.MoveSmart;
import controllers.GameController;
import controllers.HpItemController;
import gamemain.Game;
import models.GameModel;
import models.ItemModel;
import models.ObjectModel;
import utils.Utils;

import java.util.Vector;

/**
 * Created by EDGY on 3/25/2017.
 */
public class ItemHpRegenManager {
    public static final int DELAY_ADD_ITEM_HP = 8000;
    public static int timeCountAddItemHP = 3800;
    public static int timeAlive = 0;

    public ItemHpRegenManager() {
    }

    public static void addHpUpItems(Vector<GameController> gameControllers) {
        timeCountAddItemHP+=Game.GAME_LOOP_TIME;
        timeAlive+=Game.GAME_LOOP_TIME;
        if (timeCountAddItemHP>=DELAY_ADD_ITEM_HP) {
            timeCountAddItemHP = 0;
            HpItemController itemController = new HpItemController(Utils.randomAll(Game.FRAME_WIDTH / 3, Game.FRAME_WIDTH * 2 / 3),
                    Utils.randomAll(Game.OUTSIDE, Game.FRAME_HEIGHT),
                    Utils.loadImageFromres("hpRegen.png"));
            gameControllers.add(itemController);
        }
    }

}
