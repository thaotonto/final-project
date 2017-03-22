package models;

import behavior.move.MoveBehavior;
import behavior.move.MoveDownBehavior;
import behavior.move.MoveUpBehavior;
import gamemain.Game;

/**
 * Created by Thaotonto on 3/12/2017.
 */
public class ObjectModel extends GameModel implements GameModelCanMove{
    // Kích thước mặc định
    public static final int DEFAULT_WIDTH = 100  ;
    public static final int DEFAULT_HEIGHT = 100 ;
    // speed mặc định
    public static final int SPEED = 5;
    // Dùng speed này
    private int speed ;
    private MoveBehavior moveBehavior;

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
        if (moveBehavior != null) {
            moveBehavior.move(this);

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

    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    @Override
    public void run() {
        move();
    }
}
