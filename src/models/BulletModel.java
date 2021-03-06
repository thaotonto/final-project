package models;

import behavior.move.MoveBehavior;
import gamemain.Game;
import utils.Utils;

import java.awt.*;

/**
 * Created by TrKaJv on 16-Mar-17.
 */
public class BulletModel extends GameModel implements GameModelCanMove {
    // Kích thước mặc định
    public static final int DEFAULT_WIDTH = 30;
    public static final int DEFAULT_HEIGHT = 30;
    public static final int TIME_LIVE_MAX = 4000;
    public static final int DAMAGE = 10;

    // speed mặc định
    public static final int SPEED = 12;
    // Dùng speed này
    protected int speed;
    protected int time_live;
    // Di chuyển
    protected MoveBehavior moveBehavior;

    protected float x1 = x;
    protected float x2 = x;
    protected float y1 = y;
    protected float y2 = y;

    protected float speedX;
    protected float speedY;
    protected float angle;
    protected boolean contact;

    ObjectModel objContact;
    public BulletModel(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void move() {

    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }


    public void smartMove() {
        x+=speedX;
        y+=speedY;
        x2 = x1;
        x1 = x;
        y2 = y1;
        y1 = y;
    }

    public void encreaseTimeLive() {
        time_live+=Game.GAME_LOOP_TIME;
    }

        public void caculateSpeedOnContact(){
        x -=speedX;
        y -=speedY;
        float[] speedXY = Utils.findSpeed(objContact, x1, y1, x2, y2);
        speedX = speedXY[0];
        speedY = speedXY[1];

            float newSpeed = (float) Math.sqrt(speedX*speedX + speedY*speedY);
            float tiLe = BulletModel.SPEED/newSpeed;
            speedX = speedX*tiLe;
            speedY = speedY*tiLe;

    }

    @Override
    public Rectangle getRect() {
        return (new Rectangle((int)x+5, (int)y+5, width-10, height-10));
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void setObjContact(ObjectModel objContact) {
        this.objContact = objContact;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public ObjectModel getObjContact() {
        return objContact;
    }

    public void changeNumContact() {
        if(time_live >=TIME_LIVE_MAX){
            isAlive =false;
        }
    }
}
