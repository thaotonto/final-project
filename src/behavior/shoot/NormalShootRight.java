package behavior.shoot;

import models.GameModel;
import models.PlayerModel1;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class NormalShootRight extends ShootBehavior{
    @Override
    public void shoot(GameModel model) {
        if(model instanceof PlayerModel1){
            ((PlayerModel1) model).shootNormal();
        }
    }
}
