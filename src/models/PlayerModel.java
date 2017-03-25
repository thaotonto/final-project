package models;

import behavior.move.MoveBehavior;
import behavior.shoot.ShootBehavior;
import controllers.GameController;
import gamemain.Game;

import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 22-Mar-17.
 */
public class PlayerModel extends GameModel implements GameModelCanMove {
    // Kích cỡ mặc định của người chơi
    public static final int DEFAULT_WIDTH = 70;
    public static final int DEFAULT_HEGHT = 100;
    public static final float ANGLE_CHANGE = 1.6f;
    public static int NUM_BULLET_MAX = 3;
    public static int DISTANCE_MAX = 700;
    protected int TIME_ENCREASE_BULLET_MAX = 1500;
    protected int DELAY_MOVE_MAX = 1500;
    // Speed mặc địch
    protected final float SPEED = 3.5F;
    public static final int TIME_DELAY_SHOOT = 700;   // Khoản cách của mỗi viên đạn (về time)
    // Speed để có thể thay đổi từ bên ngoài
    protected int numBullet = NUM_BULLET_MAX;
    protected int timeEncreaseBullet = TIME_ENCREASE_BULLET_MAX;
    protected int distance = DISTANCE_MAX;
    public int TIME_DELAY_SHOOT_BECAUSE_ANIMAYION = 17 * 7;
    protected int timeDelayShootBecauseAnimation = 0;
    protected int timeCountMove;

    protected float speed;


    // Move
    protected MoveBehavior moveBehavior;
    // shoot
    protected ShootBehavior shootBehavior;
    // Nhận vào các phím
    protected BitSet bitSet;

    public BitSet getBitSet() {
        return bitSet;
    }
    // Đạn để shoot

    //góc bắn
    protected float angle;

    protected int timeCount = TIME_DELAY_SHOOT;  // thời gian đã trôi qua kể từ khi 1 viên dc bắn ra
    protected Vector<GameController> bullet;  // Vector gameObject chung để add đạn

    public PlayerModel(int x, int y, int width, int height, BitSet bitSet, Vector<GameController> bullet) {
        super(x, y, width, height);
        this.bitSet = bitSet;
        this.bullet = bullet;
        this.speed = SPEED;
        this.hp = 100;
        angle = 0;
    }


    public void hpRegen() {
        if (hp < HP_MAX) {
            this.hp += BulletModel.DAMAGE;
        }
    }

    public float getAngle() {
        return angle;
    }

    // Xác định move theo hướng nào
    @Override
    public void move() {
//        if (bitSet.get(KeyEvent.VK_W)) {
//            setMoveBehavior(new MoveUpBehavior());
//        }
//        if (bitSet.get(KeyEvent.VK_S)) {
//            setMoveBehavior(new MoveDownBehavior());
//        }
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
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void shoot() {
    }

    public int getTimeCount() {
        return timeCount;
    }

    public void encreaseBullet() {
        timeEncreaseBullet += Game.GAME_LOOP_TIME;
        if (timeEncreaseBullet >= TIME_ENCREASE_BULLET_MAX && numBullet < NUM_BULLET_MAX) {
            numBullet++;
            timeEncreaseBullet = 0;
        }
    }

    public Vector<GameController> getBullet() {
        return bullet;
    }

    public int getNumBullet() {
        return numBullet;
    }

    public int getDistance() {
        return distance;
    }
}
