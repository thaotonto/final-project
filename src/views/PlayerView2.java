package views;

import models.GameModel;
import models.PlayerModel1;
import models.PlayerModel2;
import utils.Utils;

import java.awt.*;

/**
 * Created by EDGY on 3/12/2017.
 */
public class PlayerView2 extends GameView {
    private String img = "angle.png";
    public PlayerView2(Image image) {
        super(image);
    }

    @Override
    public void draw(Graphics2D graphics, GameModel model) {
        super.draw(graphics, model);

    }
}
