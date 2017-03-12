package controllers;

import models.GameModel;
import models.ObjectModel;
import utils.Utils;
import views.GameView;
import views.ObjectView;

/**
 * Created by Thaotonto on 3/12/2017.
 */
public class ObjectController extends GameController {
    public ObjectController(GameModel model, GameView view) {
        super(model, view);
    }

    public ObjectController (int x, int y){
        this(new ObjectModel(x,y,ObjectModel.DEFAULT_WIDTH, ObjectModel.DEFAULT_HEIGHT),
                new ObjectView(Utils.loadImageFromres("round.png")));
    }
}
