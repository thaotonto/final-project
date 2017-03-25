package controllers;

import models.ExplodeModel;
import models.GameModel;
import utils.Utils;
import views.ExplodeView;
import views.GameView;

/**
 * Created by TrKaJv on 25-Mar-17.
 */
public class ExplodeCotroller extends GameController {

    public ExplodeCotroller(int x, int y ) {
        super(new ExplodeModel(x,y), new ExplodeView(Utils.loadImageFromres("explode/explode_1.png")));
    }

    @Override
    public void run() {
        super.run();
        // check da no chua

            if(!((ExplodeView) view).explodeShot()){
                model.setAlive(false);
            }

    }
}
