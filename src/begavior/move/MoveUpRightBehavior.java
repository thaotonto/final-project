package begavior.move;

import models.GameModel;
import models.GameModelCanMove;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class MoveUpRightBehavior extends MoveBehavior {
    @Override
    public void move(GameModel model) {
        if (model instanceof GameModelCanMove) {
            ((GameModelCanMove)model).moveUp();
            ((GameModelCanMove)model).moveRight();
        }
    }
}
