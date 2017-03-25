package views;

import models.*;
import utils.Utils;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class CharacterView extends GameView {

    private static final int MOOM_WIDTH = 50;
    private static final int MOON_HEIGHT = 100;
    private Animation explosionShot;
    private Animation explosionShot2;
    private Animation explosionGetHit;
    private Animation explosionGetHit2;
    private Animation explosionDie;
    private Animation explosionDie2;
    public CharacterView(Image image) {
        super(image);
        explosionShot = new Animation(51, Utils.getlistURLImage("/ninja-left/ninja-shot/ninja-shot" , 12));
        explosionShot2 = new Animation(51, Utils.getlistURLImage("/ninja-right/ninja-shot/ninja-shot",12));
        explosionGetHit =  new Animation(34, Utils.getlistURLImage("/ninja-left/ninja-hit/ninja-hit" , 11));
        explosionGetHit2 =  new Animation(34, Utils.getlistURLImage("/ninja-right/ninja-hit/ninja-hit",12));
        explosionDie  =  new Animation( 51, Utils.getlistURLImage("/ninja-left/ninja-die/ninja-die" , 10));
        explosionDie2  =  new Animation(51, Utils.getlistURLImage("/ninja-right/ninja-die/ninja-die",10));
    }

    @Override
    public void draw(Graphics2D graphics, GameModel model) {
        // ve thanh ban theo toa do player 1
        super.draw(graphics, model);
        if (model instanceof PlayerModel1) {
            BasicStroke basicStroke = new BasicStroke(5,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL );
            graphics.setStroke(basicStroke);
            graphics.setColor(new Color(185, 61, 0));

            graphics.drawImage(Utils.loadImageFromres(
                    "moon1.png"),

                    (int)model.getX()+PlayerModel1.DEFAULT_WIDTH - 6,

                    model.getMidY() - MOOM_WIDTH,
                    MOOM_WIDTH,
                    MOON_HEIGHT,
                    null);
            Graphics2D g2d = graphics;
            AffineTransform originalTransform = g2d.getTransform();
            g2d.rotate(-Math.toRadians(((PlayerModel1) model).getAngle()), (int)model.getX()+PlayerModel1.DEFAULT_WIDTH - 6,model.getMidY());
            g2d.drawImage(Utils.loadImageFromres("angle_1.png"),(int) model.getX()+PlayerModel1.DEFAULT_WIDTH - 6, model.getMidY() - 5, 600, 20,null);
            g2d.setTransform(originalTransform);
        }

        if(model instanceof PlayerModel2){
            // ve thanh ban theo toa do player 2
            BasicStroke basicStroke = new BasicStroke(5,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL );
            graphics.setStroke(basicStroke);
            graphics.setColor(new Color(185, 61, 0));

            graphics.drawImage(Utils.loadImageFromres(
                    "moon2.png"),
                    (int)model.getX()-PlayerModel1.DEFAULT_WIDTH/2 - 10,
                    model.getMidY() - MOOM_WIDTH,
                    MOOM_WIDTH,
                    MOON_HEIGHT,
                    null);
            Graphics2D g2d = graphics;
            AffineTransform originalTransform = g2d.getTransform();
            g2d.rotate(Math.toRadians(((PlayerModel2) model).getAngle()), (int)model.getX()-PlayerModel1.DEFAULT_WIDTH/2+40,model.getMidY() );
            g2d.drawImage(Utils.loadImageFromres("angle_2.png"),(int)model.getX()-PlayerModel1.DEFAULT_WIDTH/2+40, model.getMidY() - 5, 600, 20,null);
            g2d.setTransform(originalTransform);
        }
    }



    public boolean explodeShot(int i) {
        // i la player 1 or player 2
        if(i==1){
            Image temp = explosionShot.getImage();
            if (temp != null) {
                image = temp;
                return true;
            }
        } else if(i==2){
            Image temp = explosionShot2.getImage();
            if (temp != null) {
                image = temp;
                return true;
            }
        }

        return false;
    }
    public boolean explodeGetHit(int i) {
        // i la player 1 or player 2
        if(i==1){
            Image temp = explosionGetHit.getImage();
            if (temp != null) {
                image = temp;
                return true;
            }
        } else if(i==2){
            Image temp = explosionGetHit2.getImage();
            if (temp != null) {
                image = temp;
                return true;
            }
        }
        return false;
    }
    public Image explodeDie(int i) {
        // i la player 1 or player 2
        if(i==1){
            Image temp = explosionDie.getImage();
            if (temp != null) {
                image = temp;
                return image;
            }
        } else if(i==2){
            Image temp = explosionDie2.getImage();
            if (temp != null) {
                image = temp;
                return image;
            }
        }

        return null;
    }
}
