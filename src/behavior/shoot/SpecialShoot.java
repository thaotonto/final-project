package behavior.shoot;

import models.GameModel;
import models.PlayerModel;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class SpecialShoot extends ShootBehavior {
    @Override
    public void shoot(GameModel model) {
        if(model instanceof PlayerModel){
            ((PlayerModel) model).shootSpecial();
        }
    }
}
