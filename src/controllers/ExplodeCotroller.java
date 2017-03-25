package controllers;

import models.ExplodeModel;
import models.GameModel;
<<<<<<< HEAD
import utils.Utils;
=======
>>>>>>> 818c64d404506ed3060263d418fb76dac1b4b2bc
import views.ExplodeView;
import views.GameView;

import javax.rmi.CORBA.Util;

/**
 * Created by TrKaJv on 25-Mar-17.
 */
public class ExplodeCotroller extends GameController {
<<<<<<< HEAD
    public ExplodeCotroller(ExplodeModel model, ExplodeView view) {
        super(model, view);
    }

    public ExplodeCotroller(int x, int y) {
        this(new ExplodeModel(x,y,ExplodeModel.DEFAULT_WIDTH,ExplodeModel.DEFAULT_HEIGHT),
                new ExplodeView(Utils.loadImageFromres("explode/explode_1.png")));

    }

=======

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
>>>>>>> 818c64d404506ed3060263d418fb76dac1b4b2bc
}
