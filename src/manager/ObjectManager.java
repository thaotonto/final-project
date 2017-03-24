package manager;

import behavior.move.MoveDownBehavior;
import behavior.move.MoveSmart;
import behavior.move.MoveUpBehavior;
import controllers.GameController;
import controllers.ObjectController;
import gamemain.Game;
import models.GameModel;
import models.ObjectModel;


import java.util.Random;
import java.util.Vector;

/**
 * Created by Thaotonto on 3/12/2017.
 */
public class ObjectManager {
    static Random location = new Random();

    public static void addObject(Vector<GameController> gameControllers) {
        ObjectController objectController;

        objectController = new ObjectController((Game.FRAME_WIDTH - ObjectModel.DEFAULT_WIDTH) / 2, (Game.FRAME_HEIGHT - ObjectModel.DEFAULT_HEIGHT) / 2);
        GameModel gameModel = objectController.getModel();
        if (gameModel instanceof ObjectModel) {
            ((ObjectModel) gameModel).setMoveBehavior(new MoveSmart());
        }
        gameControllers.add(objectController);

        objectController = new ObjectController((Game.FRAME_WIDTH / 2 - ObjectModel.DEFAULT_WIDTH) / 2, (Game.FRAME_HEIGHT / 2 - ObjectModel.DEFAULT_HEIGHT) / 2);
        gameModel = objectController.getModel();
        if (gameModel instanceof ObjectModel) {
            ((ObjectModel) gameModel).setMoveBehavior(new MoveDownBehavior());
        }
        gameControllers.add(objectController);

//        objectController = new ObjectController((Game.FRAME_WIDTH + Game.FRAME_WIDTH / 4 + ObjectModel.DEFAULT_WIDTH) / 2, (Game.FRAME_HEIGHT / 2 - ObjectModel.DEFAULT_HEIGHT) / 2);
//        gameControllers.add(objectController);

//        objectController = new ObjectController((Game.FRAME_WIDTH / 2 - ObjectModel.DEFAULT_WIDTH) / 2, (Game.FRAME_HEIGHT + Game.FRAME_HEIGHT / 4 + ObjectModel.DEFAULT_HEIGHT) / 2);
//        gameControllers.add(objectController);

        objectController = new ObjectController((Game.FRAME_WIDTH + Game.FRAME_WIDTH / 4 + ObjectModel.DEFAULT_WIDTH) / 2, (Game.FRAME_HEIGHT + Game.FRAME_HEIGHT / 4 + ObjectModel.DEFAULT_HEIGHT) / 2);
        gameModel = objectController.getModel();
        if (gameModel instanceof ObjectModel) {
            ((ObjectModel) gameModel).setMoveBehavior(new MoveUpBehavior());
        }
        gameControllers.add(objectController);

    }
}
