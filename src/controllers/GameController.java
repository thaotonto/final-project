package controllers;

import models.GameModel;
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
        return model.checkContact(other.model);
    }

    public void onContact(GameController other) {
    }

    public boolean isActive() {
        return active;
    }
}
