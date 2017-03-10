package models;

import begavior.move.MoveBehavior;
import gamemain.Game;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class GameModelCanMove extends GameModel {
    protected MoveBehavior moveBehavior;
    private static float speed = 5;

    public GameModelCanMove(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void move() {

    }

    public void moveUp() {
        if (y - speed > 0) {
            y -= speed;
        }
    }

    public void moveDown() {
        if (y + speed < Game.FRAME_HEIGHT - this.getHeight()) {
            y += speed;
        }
    }

    public void moveLeft() {
        if (x - speed > 0) {
            x -= speed;
        }
    }

    public void moveRight() {
        if (x + speed < Game.FRAME_WIDTH - this.getWidth()) {
            x += speed;
        }
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    @Override
    public void run() {
        if (moveBehavior != null) {
            moveBehavior.move(this);
        }
    }


}
