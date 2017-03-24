package models;

import behavior.move.MoveBehavior;
import behavior.move.MoveDownBehavior;
import behavior.move.MoveSmart;
import behavior.move.MoveUpBehavior;
import gamemain.Game;

/**
 * Created by Thaotonto on 3/12/2017.
 */
public class ObjectModel extends GameModel implements GameModelCanMove {
    // Kích thước mặc định
    public static final int DEFAULT_WIDTH = 100;
    public static final int DEFAULT_HEIGHT = 100;
    // speed mặc định
    public static final int SPEED = 5;
    // Dùng speed này
    private int speed;
    private MoveBehavior moveBehavior;
    private MoveBehavior oldMoveBehavior;
    private float orbitRadius = 150;
    private float orbitSpeed = (float) (Math.PI / 64);
    private float radian;
    private float timeInterval = 0;
    private float orbitX = (Game.FRAME_WIDTH - ObjectModel.DEFAULT_WIDTH) / 2;
    private float orbitY = (Game.FRAME_HEIGHT - ObjectModel.DEFAULT_HEIGHT) / 2;
    private final int TIME = 500;
    private int timeDelay = TIME;
    private int turn = 1;

    public ObjectModel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.hp = 5;
        this.speed = SPEED;
    }

    @Override
    public void getHit(int damage) {
        this.hp -= damage;
        if (hp <= 0) {
            hp = 5;
        }
    }

    @Override
    public void move() {
        if (timeDelay == TIME) turn = 1;
        if (turn == 1) {
            timeDelay--;
            if (timeDelay == 0 ) {
                turn = 2;
            }
            if (moveBehavior instanceof MoveSmart) {

            } else {
                if (moveBehavior != null) {
                    moveBehavior.move(this);
                }
            }
        } else {
            timeDelay ++;
            if (moveBehavior instanceof MoveSmart) {
                moveBehavior.move(this);
            }
        }

    }

    public void moveUp() {
        if (y - speed > 0) {
            y -= speed;
        } else {
            setMoveBehavior(new MoveDownBehavior());
        }
    }

    public void moveDown() {
        if (y + speed < Game.FRAME_HEIGHT - this.getHeight()) {
            y += speed;
        } else {
            setMoveBehavior(new MoveUpBehavior());
        }
    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void smartMove() {
        radian = orbitSpeed * timeInterval;
        x = (float) (orbitX + orbitRadius * Math.cos(radian));
        y = (float) (orbitY + orbitRadius * Math.sin(radian));
        timeInterval += 1;
    }


    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    @Override
    public void run() {
        move();
    }
}
