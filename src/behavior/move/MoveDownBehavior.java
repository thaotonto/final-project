package behavior.move;

import models.GameModel;
import models.GameModelCanMove;
import models.PlayerModel1;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class MoveDownBehavior extends MoveBehavior {
    @Override
    public void move(GameModel model) {
        if (model instanceof GameModelCanMove) {
            ((GameModelCanMove)model).moveDown();
        }
    }
}
