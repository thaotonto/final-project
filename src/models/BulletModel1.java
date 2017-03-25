package models;

import behavior.move.MoveBehavior;
import gamemain.Game;
import utils.Utils;

import java.awt.*;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletModel1 extends BulletModel {

    public BulletModel1(int x, int y, int width, int height, float angle) {
        super(x, y, width, height);
        this.speed = SPEED;
        this.angle = angle;
    }

    @Override
    public void moveRight() {
        angleChangeRight();
        x += speedX;
        y += speedY;
    }

    public void angleChangeRight(){
        if(angle > 0){
            speedY = -(float)(speed*Math.sin(Math.toRadians(angle)));
            speedX = (float) (speed*Math.cos(Math.toRadians(angle)));
        }
        else if(angle < 0){
            speedY = -(float) (speed*Math.sin(Math.toRadians(angle)));
            speedX = (float) (speed*Math.cos(Math.toRadians(angle)));
        } else if(angle == 0){
            speedY = 0;
            speedX = speed;
        }
    }



    public void caculateSpeed(){
        // Đập cạnh bên phải
        if ((x + (x1 - x2)) > (Game.FRAME_WIDTH - DEFAULT_WIDTH)) {
            speedX=-speedX;
            objContact = null;
            // Đập cạnh bên trái
        } else if ((x + (x1 - x2)) < 0) {
            speedX=-speedX;
            objContact = null;
            // Đập cạnh dưới
        } else if ((y + (y1 - y2)) > (Game.FRAME_HEIGHT -BulletModel.DEFAULT_WIDTH)) {
            speedY = -speedY;
            objContact = null;
            // Đập cạnh trên
        } else if ((y + (y1 - y2)) < 0) {
            speedY = -speedY;
            objContact = null;
        } else {
            // Đang di chuyển sang trái
            if (x2 == x1) {
                moveRight();
            }
            // Đang di chuyển xuống dưới
        }
    }

    @Override
    public void run() {
        if(contact == true){
            caculateSpeedOnContact();
        }else {
            caculateSpeed();
        }
        moveBehavior.move(this);
        contact = false;
        encreaseTimeLive();
    }

}
