package controllers;

import models.ExplodeModel;
import models.GameModel;
import utils.Utils;
import views.ExplodeView;
import views.GameView;

import javax.rmi.CORBA.Util;

/**
 * Created by TrKaJv on 25-Mar-17.
 */
public class ExplodeCotroller extends GameController {
    public ExplodeCotroller(ExplodeModel model, ExplodeView view) {
        super(model, view);
    }

    public ExplodeCotroller(int x, int y) {
        this(new ExplodeModel(x,y,ExplodeModel.DEFAULT_WIDTH,ExplodeModel.DEFAULT_HEIGHT),
                new ExplodeView(Utils.loadImageFromres("explode/explode_1.png")));

    }

}
