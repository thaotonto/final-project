package models;

import begavior.move.*;
import gamemain.Game;

import java.awt.event.KeyEvent;
import java.util.BitSet;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerModel extends GameModel implements CanMove {
    public static final int DEFAULT_WIDTH = 70;
    public static final int DEFAULT_HEGHT = 100;
    private final float SPEED = 1.5F;
    private final float speed;
    private MoveBehavior moveBehavior;

    BitSet bitSet;

    public PlayerModel(int x, int y, int width, int height, BitSet bitSet) {
        super(x, y, width, height);
        this.bitSet = bitSet;
        this.speed = SPEED;
    }

    @Override
    public void move() {
        if (bitSet.get(KeyEvent.VK_UP)) {
            setMoveBehavior(new MoveUpBehavior());
        }
        if (bitSet.get(KeyEvent.VK_DOWN)) {
            setMoveBehavior(new MoveDownBehavior());
        }
        if (bitSet.get(KeyEvent.VK_LEFT)) {
            setMoveBehavior(new MoveLeftBehavior());
        }
        if (bitSet.get(KeyEvent.VK_RIGHT)) {
            setMoveBehavior(new MoveRightBehavior());
        }


        if (bitSet.get(KeyEvent.VK_UP) && bitSet.get(KeyEvent.VK_RIGHT)) {
            setMoveBehavior(new MoveUpRightBehavior());
        }
        if (bitSet.get(KeyEvent.VK_UP) && bitSet.get(KeyEvent.VK_LEFT)) {
            setMoveBehavior(new MoveUpLeftBehavior());
        }

        if (bitSet.get(KeyEvent.VK_DOWN) && bitSet.get(KeyEvent.VK_LEFT)) {
            setMoveBehavior(new MoveDownLeftBehavior());
        }

        if (bitSet.get(KeyEvent.VK_DOWN) && bitSet.get(KeyEvent.VK_RIGHT)) {
            setMoveBehavior(new MoveDownRightBehavior());
        }
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

    @Override
    public void run() {
        super.run();
        move();
        if (moveBehavior != null) {
            moveBehavior.move(this);
        }
        setMoveBehavior(null);
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }
}
