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
    // speed mặc định
    public static final int SPEED = 5;
    // Dùng speed này
    protected int speed;
    // Di chuyển
    protected MoveBehavior moveBehavior;

    protected float x1 = x;
    protected float x2 = x;
    protected float y1 = y;
    protected float y2 = y;
    protected int damage=10;
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

    public void caculateSpeedOnContact(){
        float[] speedXY = Utils.findSpeed(objContact, x1, y1, x2, y2);
        speedX = speedXY[0];
        speedY = speedXY[1];
    }

    @Override
    public Rectangle getRect() {
        return (new Rectangle((int)x+5, (int)y+5, width-10, height-10));
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public int getDamage() {
        return damage;
    }

    public void setObjContact(ObjectModel objContact) {
        this.objContact = objContact;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }
}
