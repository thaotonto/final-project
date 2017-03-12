package behavior.shoot;

import models.GameModel;
import models.PlayerModel1;
import models.PlayerModel2;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class NormalShootLeft extends ShootBehavior{
    @Override
    public void shoot(GameModel model) {
        if(model instanceof PlayerModel2){
            ((PlayerModel2) model).shootNormalLeft();
        }
    }
}
