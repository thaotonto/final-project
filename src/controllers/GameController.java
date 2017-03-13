package controllers;

import models.GameModel;
import models.ObjectModel;
import utils.Utils;
import views.GameView;

import java.awt.*;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class GameController {
    protected GameModel model;
    protected GameView view;
    protected boolean active = true;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        model.run();
    }

    public void draw(Graphics2D graphics) {
        view.draw(graphics, model);
    }

    public GameModel getModel() {
        return model;
    }

    public GameView getView() {
        return view;
    }

    public boolean checkContact(GameController other) {
        Rectangle obj1 = model.getRect();
        Rectangle obj2 = other.model.getRect();
        if (other instanceof ObjectController && this instanceof BulletController1) {
            return Utils.checkContactWithCircle(this.model, (ObjectModel) ((ObjectController) other).model);
        } else if (this instanceof ObjectController) {
            return Utils.checkContactWithCircle(other.model, (ObjectModel) this.model);
        } else {
            return (obj1.intersects(obj2));
        }
    }


    public void onContact(GameController other) {
    }

    public boolean isActive() {
        return active;
    }
}
