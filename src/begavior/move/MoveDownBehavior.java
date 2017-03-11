package begavior.move;

import models.CanMove;
import models.GameModel;
import models.GameModelCanMove;
import models.PlayerModel;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class MoveDownBehavior extends MoveBehavior {
    @Override
    public void move(GameModel model) {
        if (model instanceof PlayerModel) {
            ((PlayerModel)model).moveDown();
        }
    }
}
