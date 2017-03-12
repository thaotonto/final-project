package views;

import models.GameModel;
import models.PlayerModel1;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerView1 extends GameView {
    private String img = "angle.png";

    public PlayerView1(Image image) {
        super(image);
    }

    @Override
    public void draw(Graphics2D graphics, GameModel model) {
        super.draw(graphics, model);
        if (model instanceof PlayerModel1) {
            int speed = 10;
            int speedX = 0;
            int speedY = 0;
            if (((PlayerModel1) model).getNumberOfBullet() == 0) {
                if (((PlayerModel1) model).getAngle() > 0) {
                    speedY = -(int) (speed * Math.sin(-Math.toRadians(((PlayerModel1) model).getNumberOfBullet())));
                    speedX = (int) (speed * Math.cos(Math.toRadians(((PlayerModel1) model).getNumberOfBullet())));
                } else if (((PlayerModel1) model).getAngle() < 0) {
                    speedX = (int) (speed * Math.sin(Math.toRadians(90 + ((PlayerModel1) model).getNumberOfBullet())));
                    speedY = -(int) (speed * Math.sin(Math.toRadians(((PlayerModel1) model).getNumberOfBullet())));
                }
            }
            graphics.drawLine(model.getMidX(), model.getMidY(), speedX, speedY);
        }
    }
}


