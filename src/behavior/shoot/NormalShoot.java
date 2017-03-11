package behavior.shoot;

import models.GameModel;
import models.PlayerModel;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class NormalShoot extends ShootBehavior{
    @Override
    public void shoot(GameModel model) {
        if(model instanceof PlayerModel){
            ((PlayerModel) model).shootNormal();
        }
    }
}
