package models;

import behavior.move.MoveBehavior;
import gamemain.Game;
import utils.Utils;

import java.awt.*;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletModel2 extends GameModel implements GameModelCanMove {
    // Kích thước mặc định
    public static final int DEFAULT_WIDTH = 30;
    public static final int DEFAULT_HEIGHT = 30;
    // speed mặc định
    public static final int SPEED = 5;
    // Dùng speed này
    private int speed;
    // Di chuyển
    private MoveBehavior moveBehavior;

    private float x1 = x;
    private float x2 = x;
    private float y1 = y;
    private float y2 = y;
    protected int damage = 10;
    private float speedX;
    private float speedY;
    private float angle;
    private boolean contact;
    private ObjectModel objContact;

    public BulletModel2(int x, int y, int width, int height, float angle) {
        super(x, y, width, height);
        this.speed = SPEED;
        this.angle = angle;
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
        AngleChangeLeft();
        x += speedX;
        y += speedY;
    }

    @Override
    public void moveRight() {
    }

    public void AngleChangeLeft() {
        if (angle > 0) {
            speedY = -(float) (speed * Math.sin(-Math.toRadians(angle)));
            speedX = (float) (speed * Math.cos(Math.toRadians(angle)));
        } else if (angle < 0) {
            speedX = (float) (speed * Math.sin(Math.toRadians(90 + angle)));
            speedY = -(float) (speed * Math.sin(Math.toRadians(angle)));
        } else if (angle == 0) {
            speedY = 0;
            speedX = speed;
        }
    }

    public void smartMove() {

        x += speedX;
        y += speedY;

        x2 = x1;
        x1 = x;
        y2 = y1;
        y1 = y;

    }

    public void caculateSpeed() {
        // Đập cạnh bên phải
        if ((x + (x1 - x2)) > (Game.FRAME_WIDTH - DEFAULT_WIDTH)) {
            speedX = -speedX;
            if (y2 < y1) {

            } else {
            }
            // Đập cạnh bên trái
        } else if ((x + (x1 - x2)) < 0) {
            speedX = -speedX;
            if (y2 < y1) {
            } else {
            }
            // Đập cạnh dưới
        } else if ((y + (y1 - y2)) > (Game.FRAME_HEIGHT)) {
            speedY = -speedY;
            if (x2 < x1) {
            } else {
            }
            // Đập cạnh trên
        } else if ((y + (y1 - y2)) < 0) {
            speedY = -speedY;
            if (x2 < x1) {
            } else {
            }
        } else {
            // Đang di chuyển sang trái
            if (x2 > x1) {
            } else if (x2 == x1) {
                moveLeft();
            } else {
            }
            // Đang di chuyển xuống dưới
            if (y2 > y1) {
            } else {
            }
        }
    }

    public void caculateSpeedOnContact() {
        float[] speedXY = Utils.findSpeed(objContact, x1, y1, x2, y2);
        speedX = speedXY[0];
        speedY = speedXY[1];
        System.out.println(speedX);
        System.out.println(speedY);
    }

    @Override
    public void run() {
        if (contact == true) {
            caculateSpeedOnContact();
        } else {
            caculateSpeed();
        }
        moveBehavior.move(this);
        contact = false;

    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public Rectangle getRect() {
        return (new Rectangle((int) x + 10, (int) y + 10, width - 20, height - 20));
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public void setObjContact(ObjectModel objContact) {
        this.objContact = objContact;
    }
}
