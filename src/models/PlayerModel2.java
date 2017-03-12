package models;

import behavior.move.*;
import behavior.shoot.NormalShootLeft;
import behavior.shoot.NormalShootRight;
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
public class PlayerModel2 extends GameModel implements GameModelCanMove, GameModelCanShoot {
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
    private int numberOfBullet = 0; //Đếm lượng đạn đã shoot
    private int numberOfBulletMax;  //Đạn max
    private int timeDelayShoot = 500;   // Khoản cách của mỗi viên đạn (về time)
    private int timeCount = 0;  // thời gian đã trôi qua kể từ khi 1 viên dc bắn ra
    private Vector<GameController> bullet;  // Vector gameObject chung để add đạn

    public PlayerModel2(int x, int y, int width, int height, BitSet bitSet, Vector<GameController> bullet) {
        super(x, y, width, height);
        this.bitSet = bitSet;
        this.bullet = bullet;
        this.numberOfBulletMax = 5;
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
//        if (bitSet.get(KeyEvent.VK_LEFT)) {
//            setMoveBehavior(new MoveLeftBehavior());
//        }
//        if (bitSet.get(KeyEvent.VK_RIGHT)) {
//            setMoveBehavior(new MoveRightBehavior());
//        }


//        if (bitSet.get(KeyEvent.VK_UP) && bitSet.get(KeyEvent.VK_RIGHT)) {
//            setMoveBehavior(new MoveUpRightBehavior());
//        }
//        if (bitSet.get(KeyEvent.VK_UP) && bitSet.get(KeyEvent.VK_LEFT)) {
//            setMoveBehavior(new MoveUpLeftBehavior());
//        }
//
//        if (bitSet.get(KeyEvent.VK_DOWN) && bitSet.get(KeyEvent.VK_LEFT)) {
//            setMoveBehavior(new MoveDownLeftBehavior());
//        }
//
//        if (bitSet.get(KeyEvent.VK_DOWN) && bitSet.get(KeyEvent.VK_RIGHT)) {
//            setMoveBehavior(new MoveDownRightBehavior());
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
        if (numberOfBullet >= numberOfBulletMax) {
            shootBehavior = null;
        }
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

    // Khi đổi lại lượt
    private void resetShoot() {
        numberOfBullet = 0;
    }

    // Set khi bắn
    @Override
    public void shoot() {
        if (bitSet.get(KeyEvent.VK_SPACE)) {
            shootBehavior = new NormalShootLeft();
        }

        if (bitSet.get(KeyEvent.VK_C)) {
            resetShoot();
        }
    }

    @Override
    public void shootNormalRight() {
    }

    @Override
    public void shootNormalLeft() {
        // Tăng time kể từ lần bắn trước
        timeCount += Game.GAME_LOOP_TIME;

        if (timeCount >= timeDelayShoot) {      // Đủ time bắn
            // set lại
            timeCount = 0;
            // Tăng lượng đạn đã bắn
            numberOfBullet++;
            // Bắn
            BulletController bulletController = new BulletController(this.getMidX(), this.getMidY());
            ((BulletModel)bulletController.getModel()).setMoveBehavior(new MoveLeftBehavior());
            bullet.add(bulletController);
        }
    }

    @Override
    public void shootSpecial() {

    }
}
