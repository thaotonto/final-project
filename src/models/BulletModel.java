package models;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public class BulletModel extends GameModel implements GameModelCanMove {
    // Kích thước mặc định
    public static final int DEFAULT_WIDTH = 45;
    public static final int DEFAULT_HEIGHT = 45;
    // speed mặc định
    public static final int SPEED = 5;
    // Dùng speed này
    private int speed ;

    public BulletModel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.speed =SPEED;
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
        x+=speed;
    }

    @Override
    public void moveRight() {

    }

    @Override
    public void run() {
        moveLeft();
    }
}
