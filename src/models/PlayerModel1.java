package models;

import behavior.move.*;
import behavior.shoot.ShootBehavior;
import controllers.BulletController1;
import controllers.GameController;
import gamemain.Game;

import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerModel1 extends GameModel implements GameModelCanMove {

    // Kích cỡ mặc định của người chơi
    public static final int DEFAULT_WIDTH = 70;
    public static final int DEFAULT_HEGHT = 100;
    public static final float ANGLE_CHANGE = 3f;
    // Speed mặc địch
    private final float SPEED = 3.5F;
    // Speed để có thể thay đổi từ bên ngoài
    private final float speed;

    // Move
    private MoveBehavior moveBehavior;
    // shoot
    private ShootBehavior shootBehavior;
    // Nhận vào các phím
    private BitSet bitSet;

    public BitSet getBitSet() {
        return bitSet;
    }
    // Đạn để shoot

    //góc bắn
    private float angle;
    private static boolean canMove = true;

    private int timeDelayShoot = 200;   // Khoản cách của mỗi viên đạn (về time)
    private int timeCount = timeDelayShoot;  // thời gian đã trôi qua kể từ khi 1 viên dc bắn ra
    private Vector<GameController> bullet;  // Vector gameObject chung để add đạn

    public PlayerModel1(int x, int y, int width, int height, BitSet bitSet, Vector<GameController> bullet) {
        super(x, y, width, height);
        this.bitSet = bitSet;
        this.bullet = bullet;
        this.speed = SPEED;
        this.hp = 100;
        angle = 0;
    }

    public float getAngle() {
        return angle;
    }

    // Xác định move theo hướng nào
    @Override
    public void move() {
        if (bitSet.get(KeyEvent.VK_W)) {
            setMoveBehavior(new MoveUpBehavior());
        }
        if (bitSet.get(KeyEvent.VK_S)) {
            setMoveBehavior(new MoveDownBehavior());
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
    public void smartMove() {

    }

    @Override
    public void run() {
        super.run();
        // set move (Nhận xem move bên nào)
        move();
        //move
        if (moveBehavior != null) {
            moveBehavior.move(this);
        }
        setMoveBehavior(null);

        // set shoot (Nhận xem move bên nào)
        shoot();
        if (shootBehavior != null) {
            shootBehavior.shoot(this);
        }
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    // Set khi bắn
    public void shoot() {
        if (bitSet.get(KeyEvent.VK_A)) {
            if (angle <= 70) {
                angle += ANGLE_CHANGE;
            }

        }
        if (bitSet.get(KeyEvent.VK_D)) {
            if (angle >= -70) {
                angle -= ANGLE_CHANGE;
            }
        }

        timeCount += Game.GAME_LOOP_TIME;
        if (bitSet.get(KeyEvent.VK_SPACE)) {
            shootNormal();
        }
    }

    public void shootNormal() {
        // Tăng time kể từ lần bắn trước

        if (timeCount >= timeDelayShoot) {      // Đủ time bắn
            // set lại
            timeCount = 0;
            // Tăng lượng đạn đã bắn
            // Bắn
            BulletController1 bulletController1 = new BulletController1((int) this.getX() + DEFAULT_WIDTH + 5, this.getMidY(), angle);
            ((BulletModel1) bulletController1.getModel()).setMoveBehavior(new MoveLeftHeroBehavior());
            bullet.add(bulletController1);
        }
    }


}
