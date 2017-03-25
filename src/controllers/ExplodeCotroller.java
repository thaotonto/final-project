package controllers;

import models.ExplodeModel;
import models.GameModel;
import views.ExplodeView;
import views.GameView;

/**
 * Created by TrKaJv on 25-Mar-17.
 */
public class ExplodeCotroller extends GameController {

    public ExplodeCotroller(GameModel model, GameView view) {
        super(model, view);
    }

    @Override
    public void run() {
        super.run();
        // check da no chua
        if(((ExplodeModel)model).isCheckExployde() ){
            if(!((ExplodeView) view).explodeShot()){
                model.setAlive(false);
            }
        }
    }
}
