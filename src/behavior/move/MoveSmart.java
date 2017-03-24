package behavior.move;

import models.GameModel;
import models.GameModelCanMove;

/**
 * Created by Thaotonto on 3/25/2017.
 */
public class MoveSmart extends MoveBehavior {
    @Override
    public void move(GameModel model) {
        if(model instanceof GameModelCanMove){
            ((GameModelCanMove)model).smartMove();
        }
    }
}
