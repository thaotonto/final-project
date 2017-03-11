package behavior.move;

import models.GameModel;
import models.GameModelCanMove;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class MoveDownRightBehavior extends MoveBehavior {
    @Override
    public void move(GameModel model) {
        if (model instanceof GameModelCanMove) {
            ((GameModelCanMove)model).moveDown();
            ((GameModelCanMove)model).moveRight();
        }
    }
}
