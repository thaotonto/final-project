package views;

import models.*;
import utils.Utils;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class CharacterView extends GameView {


    private Animation explosionShot;
    private Animation explosionShot2;
    private Animation explosionGetHit;
    private Animation explosionGetHit2;
    private Animation explosionDie;
    private Animation explosionDie2;
    public CharacterView(Image image) {
        super(image);
        explosionShot = new Animation(100, Utils.getlistURLImage("/ninja-left/ninja-shot/ninja-shot" , 12));
        explosionShot2 = new Animation(100, Utils.getlistURLImage("/ninja-right/ninja-shot/ninja-shot",12));
        explosionGetHit =  new Animation(100, Utils.getlistURLImage("/ninja-left/ninja-hit/ninja-hit" , 11));
        explosionGetHit2 =  new Animation(100, Utils.getlistURLImage("/ninja-right/ninja-hit/ninja-hit",12));
        explosionDie  =  new Animation( 100, Utils.getlistURLImage("/ninja-left/ninja-die/ninja-die" , 10));
        explosionDie2  =  new Animation(100, Utils.getlistURLImage("/ninja-right/ninja-die/ninja-die",10));
    }

    @Override
    public void draw(Graphics2D graphics, GameModel model) {
        super.draw(graphics, model);
        if (model instanceof PlayerModel1) {
            BasicStroke basicStroke = new BasicStroke(5,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL );
            graphics.setStroke(basicStroke);
            graphics.setColor(new Color(185, 61, 0));
//            int speed = 100;
//            int speedX = 0;
//            int speedY = 0;
//            if(((PlayerModel1) model).getAngle() > 0){
//                speedY = -(int) (speed*Math.sin(Math.toRadians(((PlayerModel1) model).getAngle())));
//                speedX = (int) (speed*Math.cos(Math.toRadians(((PlayerModel1) model).getAngle())));
//            }
//            else if(((PlayerModel1) model).getAngle() < 0){
//                speedX = (int) (speed*Math.sin(Math.toRadians(90+((PlayerModel1) model).getAngle())));
//                speedY = (int) (speed*Math.sin(-Math.toRadians(((PlayerModel1) model).getAngle())));
//            } else if(((PlayerModel1) model).getAngle() == 0){
//                speedY = 0;
//                speedX = speed;
//            }
//            graphics.drawLine((int) (model.getX()+model.getWidth()), model.getMidY(), (int) (model.getX()+model.getWidth())+speedX, model.getMidY()+speedY);
            Graphics2D g2d = graphics;
            AffineTransform originalTransform = g2d.getTransform();
            g2d.rotate(-Math.toRadians(((PlayerModel1) model).getAngle()), (int)model.getX()+PlayerModel1.DEFAULT_WIDTH - 6,model.getMidY());
            g2d.drawImage(Utils.loadImageFromres("angle.png"),(int) model.getX()+PlayerModel1.DEFAULT_WIDTH - 6, model.getMidY() - 5, 70, 7,null);
            g2d.setTransform(originalTransform);
        }

        if(model instanceof PlayerModel2){
            BasicStroke basicStroke = new BasicStroke(5,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL );
            graphics.setStroke(basicStroke);
            graphics.setColor(new Color(185, 61, 0));
//            int speed = 100;
//            int speedX = 0;
//            int speedY = 0;
//            if(((PlayerModel2) model).getAngle() > 0){
//                speedY = -(int) (speed*Math.sin(-Math.toRadians(((PlayerModel2) model).getAngle())));
//                speedX = (int) (speed*Math.cos(Math.toRadians(((PlayerModel2) model).getAngle())));
//            }
//            else if(((PlayerModel2) model).getAngle() < 0){
//                speedX = (int) (speed*Math.sin(Math.toRadians(90+((PlayerModel2) model).getAngle())));
//                speedY = -(int) (speed*Math.sin(Math.toRadians(((PlayerModel2) model).getAngle())));
//            } else if(((PlayerModel2) model).getAngle() == 0){
//                speedY = 0;
//                speedX = speed;
//            }
//            graphics.drawLine((int) model.getX(), model.getMidY(), (int) (model.getX()+speedX), model.getMidY()+speedY);
            Graphics2D g2d = graphics;
            AffineTransform originalTransform = g2d.getTransform();
            g2d.rotate(Math.toRadians(((PlayerModel2) model).getAngle()), (int)model.getX()-PlayerModel1.DEFAULT_WIDTH/2+40,model.getMidY() );
            g2d.drawImage(Utils.loadImageFromres("angle.png"),(int)model.getX()-PlayerModel1.DEFAULT_WIDTH/2+40, model.getMidY() - 5, 70, 7,null);
            g2d.setTransform(originalTransform);
        }
    }



    public boolean explodeShot(int i) {
       // explosion = new Animation(11, 1000, "ninja-left/ninja-shot");
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
      //  explosion = new Animation(11, 1000, "ninja-left/ninja-hit");
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
    public boolean explodeDie(int i) {
        //  explosion = new Animation(11, 1000, "ninja-left/ninja-hit");
        if(i==1){
            Image temp = explosionDie.getImage();
            if (temp != null) {
                image = temp;
                return true;
            }
        } else if(i==2){
            Image temp = explosionDie2.getImage();
            if (temp != null) {
                image = temp;
                return true;
            }
        }

        return false;
    }
}
