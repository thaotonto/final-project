package models;

import behavior.move.*;
import controllers.BulletController2;
import controllers.GameController;
import gamemain.Game;

import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerModel2 extends PlayerModel {
    public PlayerModel2(int x, int y, int width, int height, BitSet bitSet, Vector<GameController> bullet) {
        super(x, y, width, height, bitSet, bullet);
        this.speed = SPEED;
        this.hp = 100;
        angle = 180;
    }
//    // Kích cỡ mặc định của người chơi
//    public static final int DEFAULT_WIDTH = 70;
//    public static final int DEFAULT_HEGHT = 100;
//    public static final float ANGLE_CHANGE = 1f;
//    // Speed mặc địch
//    private final float SPEED = 3.5F;
//    // Speed để có thể thay đổi từ bên ngoài
//    private final float speed;
//
//    // Move
//    private MoveBehavior moveBehavior;
//    // shoot
//    private ShootBehavior shootBehavior;
//    // Nhận vào các phím
//    private BitSet bitSet;
//    // Đạn để shoot
//
//    public BitSet getBitSet() {
//        return bitSet;
//    }
//
//    //góc bắn
//    private float angle;
//    private int TIME_DELAY_SHOOT = 500;   // Khoản cách của mỗi viên đạn (về time)
//    private int timeCount = TIME_DELAY_SHOOT;  // thời gian đã trôi qua kể từ khi 1 viên dc bắn ra
//    private Vector<GameController> bullet;  // Vector gameObject chung để add đạn
//
//    public PlayerModel2(int x, int y, int width, int height, BitSet bitSet, Vector<GameController> bullet) {
//        super(x, y, width, height);
//        this.bitSet = bitSet;
//        this.bullet = bullet;
//        this.speed = SPEED;
//        this.hp = 100;
//        angle = 180;
//    }
//
//    public float getAngle() {
//        return angle;
//    }
//
    // Xác định move theo hướng nào
    @Override
    public void move() {
        if (bitSet.get(KeyEvent.VK_UP)) {
            setMoveBehavior(new MoveUpBehavior());
        }
        if (bitSet.get(KeyEvent.VK_DOWN)) {
            setMoveBehavior(new MoveDownBehavior());
        }
    }
//
//    public void moveUp() {
//        if (y - speed > 0) {
//            y -= speed;
//        }
//    }
//
//    public void moveDown() {
//        if (y + speed < Game.FRAME_HEIGHT - this.getHeight()) {
//            y += speed;
//        }
//    }
//
//    public void moveLeft() {
//        if (x - speed > 0) {
//            x -= speed;
//        }
//    }
//
//    public void moveRight() {
//        if (x + speed < Game.FRAME_WIDTH - this.getWidth()) {
//            x += speed;
//        }
//    }
//
//    @Override
//    public void smartMove() {
//
//    }
//
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
        // Nếu bắn đủ số đạn rồi thì không bắn nữa
        if (shootBehavior != null) {
            shootBehavior.shoot(this);
        }
    }
//
//    public MoveBehavior getMoveBehavior() {
//        return moveBehavior;
//    }
//
//    public void setMoveBehavior(MoveBehavior moveBehavior) {
//        this.moveBehavior = moveBehavior;
//    }

    // Set khi bắn
    public void shoot() {
        if (bitSet.get(KeyEvent.VK_LEFT)) {
            if (angle <= 240) {
                angle += ANGLE_CHANGE;
            }

        }
        if (bitSet.get(KeyEvent.VK_RIGHT)) {
            if (angle >= 110) {
                angle -= ANGLE_CHANGE;
            }
        }

        if (timeCount < TIME_DELAY_SHOOT) {
            timeCount += Game.GAME_LOOP_TIME;
        }
        if (bitSet.get(KeyEvent.VK_NUMPAD0)) {
            shootNormal();
        }
    }

    public void shootNormal() {
        // Tăng time kể từ lần bắn trước

        if (timeCount >= TIME_DELAY_SHOOT) {      // Đủ time bắn
            // set lại
            timeCount = 0;
            // Bắn
            BulletController2 bulletController2 = new BulletController2((int) this.getX() - DEFAULT_WIDTH - 5, this.getMidY(), angle);
            ((BulletModel2) bulletController2.getModel()).setMoveBehavior(new MoveRightHeroBehavior());
            bullet.add(bulletController2);
        }
    }

}