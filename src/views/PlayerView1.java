package views;

import models.GameModel;
import models.PlayerModel1;
import utils.Utils;

import java.awt.*;
import java.awt.geom.AffineTransform;
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
        if(model instanceof PlayerModel1){
            if(((PlayerModel1) model).getNumberOfBullet() == 0){
                BufferedImage image = (BufferedImage) Utils.loadImageFromres(img);
                BufferedImage buffer = new BufferedImage(image.getWidth(null), image.getHeight(null), image.getType());
                Graphics2D rotateGraphics = (Graphics2D) buffer.getGraphics();
//                rotateGraphics.translate(model.getX() + model.getWidth(), model.getMidY());
                rotateGraphics.rotate(((PlayerModel1) model).getAngle());
                rotateGraphics.drawImage(image, 0,0,50,10,null);
                graphics.drawImage(buffer, (int) (model.getX() + model.getWidth()), model.getMidY(),model.getWidth(),model.getHeight(),null);
//                graphics.rotate(-((PlayerModel1) model).getAngle());
                graphics.translate(0, 0);
            }
        }
    }
}


