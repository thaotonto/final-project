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
            BasicStroke basicStroke = new BasicStroke(5,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL );
            graphics.setStroke(basicStroke);
            graphics.setColor(new Color(185, 61, 0));
            int speed = 100;
            int speedX = 0;
            int speedY = 0;
            if(((PlayerModel1) model).getAngle() > 0){
                speedY = -(int) (speed*Math.sin(Math.toRadians(((PlayerModel1) model).getAngle())));
                speedX = (int) (speed*Math.cos(Math.toRadians(((PlayerModel1) model).getAngle())));
            }
            else if(((PlayerModel1) model).getAngle() < 0){
                speedX = (int) (speed*Math.sin(Math.toRadians(90+((PlayerModel1) model).getAngle())));
                speedY = (int) (speed*Math.sin(-Math.toRadians(((PlayerModel1) model).getAngle())));
            } else if(((PlayerModel1) model).getAngle() == 0){
                speedY = 0;
                speedX = speed;
            }
            graphics.drawLine(model.getMidX(), model.getMidY(), model.getMidX()+speedX, model.getMidY()+speedY);
        }
    }
}


