package models;

import behavior.move.MoveBehavior;
import gamemain.Game;

import java.awt.*;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletModel1 extends GameModel implements GameModelCanMove {
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
    protected int damage=10;
    private float speedX;
    private float speedY;
    private float angle;

    public BulletModel1(int x, int y, int width, int height, float angle) {
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


    public void smartMove() {
        // Đập cạnh bên phải
        if ((x + (x1 - x2)) > (Game.FRAME_WIDTH - DEFAULT_WIDTH)) {
//            System.out.println("phải");
//            moveLeft();
            speedX=-speedX;
            x+=speedX;
            if (y2 < y1) {
//                moveDown();
                y+=speedY;

            } else {
//                moveUp();
                y+=speedY;
            }
            // Đập cạnh bên trái
        } else if ((x + (x1 - x2)) < 0) {
//            System.out.println("trái");
            speedX=-speedX;
            x+=speedX;
            if (y2 < y1) {
//                moveDown();
                y+=speedY;
            } else {
//                moveUp();
                y+=speedY;
            }
            // Đập cạnh dưới
        } else if ((y + (y1 - y2)) > (Game.FRAME_HEIGHT )) {
//            System.out.println("dưới");
//            moveUp();
            speedY = -speedY;
            y+=speedY;
            if (x2 < x1) {
                x+=speedX;
            } else {
                x+=speedX;
            }
            // Đập cạnh trên
        } else if ((y + (y1 - y2)) < 0) {
//            System.out.println("trên");
            speedY = -speedY;
            y+=speedY;
            if (x2 < x1) {
                x+=speedX;
            } else {
                x+=speedX;
            }
        } else {
//            System.out.println("========tiếp");
            // Đang di chuyển sang trái
            if (x2 > x1) {
                x+=speedX;
            } else if (x2 == x1) {
                moveRight();
            } else {
                x+=speedX;
            }
            // Đang di chuyển xuống dưới
            if (y2 > y1) {
                y+=speedY;
            } else {
                y+=speedY;
            }
        }


        x2 = x1;
        x1 = x;
        y2 = y1;
        y1 = y;

    }

    @Override
    public void run() {
        moveBehavior.move(this);

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

}
