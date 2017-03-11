package models;

import behavior.move.*;
import behavior.shoot.NormalShoot;
import behavior.shoot.ShootBehavior;
import controllers.BulletController;
import controllers.GameController;
import gamemain.Game;

import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerModel extends GameModel implements GameModelCanMove, GameModelCanShoot {
    // Kích cỡ mặc định của người chơi
    public static final int DEFAULT_WIDTH = 70;
    public static final int DEFAULT_HEGHT = 100;

    // Speed mặc địch
    private final float SPEED = 1.5F;
    // Speed để có thể thay đổi từ bên ngoài
    private final float speed;

    // Move
    private MoveBehavior moveBehavior;
    // shoot
    private ShootBehavior shootBehavior;
    // Nhận vào các phím
    private BitSet bitSet;
    // Đạn để shoot
    int numberOfBullet = 0;
    private int numberOfBulletMax;
    private Vector<GameController> bullet;

    public PlayerModel(int x, int y, int width, int height, BitSet bitSet, Vector<GameController> bullet) {
        super(x, y, width, height);
        this.bitSet = bitSet;
        this.bullet = bullet;
        this.numberOfBulletMax = 1;
        this.speed = SPEED;
    }

    // Xác định move theo hướng nào
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

        shoot();
        if (shootBehavior != null) {
            shootBehavior.shoot(this);
        }
        setMoveBehavior(null);
        shootBehavior = null;
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    @Override
    public void shoot() {
        if (bitSet.get(KeyEvent.VK_SPACE)) {
            shootBehavior = new NormalShoot();
        }
    }

    @Override
    public void shootNormal() {
        if (numberOfBullet < numberOfBulletMax) {
            numberOfBullet++;
            BulletController bulletController = new BulletController(this.getMidX(), this.getMidY());
            bullet.add(bulletController);
        }
    }

    @Override
    public void shootSpecial() {

    }
}
