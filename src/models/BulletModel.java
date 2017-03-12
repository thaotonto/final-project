package models;

import behavior.move.MoveBehavior;
import gamemain.Game;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletModel extends GameModel implements GameModelCanMove {
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
    private float y1 = x;
    private float y2 = x;

    public BulletModel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.speed = SPEED;
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
        x -= speed;
    }

    @Override
    public void moveRight() {
        x += speed;
    }

    public void smartMove() {
//        time_live += GameWindow.TIME_GAME_LOOP;
//        if (time_live >= TIM_LIVE_MAX) {
//            isAlive = false;
//        }

        // Đập cạnh bên phải
        if ((x + (x1 - x2)) > (Game.FRAME_WIDTH - DEFAULT_WIDTH)) {
            moveLeft();
            if (y2 < y1) {
                moveDown();
            } else {
                moveUp();
            }
            // Đập cạnh bên trái
        } else if ((x + (x1 - x2)) < 0) {
            moveRight();
            if (y2 < y1) {
                moveDown();
            } else {
                moveUp();
            }
            // Đập cạnh dưới
        } else if ((y + (y1 - y2)) > (Game.FRAME_HEIGHT - DEFAULT_HEIGHT - 100)) {
            moveUp();
//            moveLeft();
            if (x2 < x1) {
                moveRight();
            } else {
                moveLeft();
            }
            // Đập cạnh trên
        } else if ((y + (y1 - y2)) < 70) {
            moveDown();
            if (x2 < x1) {
                moveRight();
            } else {
                moveLeft();
            }
        } else {
            // Đang di chuyển sang trái
            if (x2 > x1) {
                moveLeft();
            } else if (x2 == x1) {
//                if (init == 0) {
//                    moveLeft();
//                } else {
//                    moveRight();
//                }
                moveBehavior.move(this);
            } else {
                moveRight();
            }
            // Đang di chuyển xuống dưới
            if (y2 > y1) {
                moveUp();
            } else {
                moveDown();
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

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }
}
