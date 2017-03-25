package models;

import behavior.move.*;
import controllers.BulletController2;
import controllers.GameController;
import gamemain.Game;
import gamemain.gamescene.PlayScene;

import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerModel2 extends PlayerModel {
    private static PlayerModel2 instance;
    public PlayerModel2(int x, int y, int width, int height, BitSet bitSet, Vector<GameController> bullet) {
        super(x, y, width, height, bitSet, bullet);
        this.speed = SPEED;
        this.hp = 100;
        angle = 180;
    }

    public static PlayerModel2 getInstance(int x, int y, BitSet bitSet, Vector<GameController> bullet){
        if(instance == null) {
            instance = new PlayerModel2(x, y, PlayerModel1.DEFAULT_WIDTH, PlayerModel1.DEFAULT_HEGHT, bitSet, bullet);
        }
        return instance;
    }

    public static PlayerModel2 getInstance(){
        return instance;
    }

    // Xác định move theo hướng nào
    @Override
    public void move() {
        if (bitSet.get(PlayScene.UP_P2) || bitSet.get(PlayScene.DOWN_P2)) {
            if (distance > 0) {
                if (bitSet.get(PlayScene.UP_P2)) {
//            setMoveBehavior(new MoveUpBehavior());
                    moveUp();
                }
                if (bitSet.get(PlayScene.DOWN_P2)) {
//            setMoveBehavior(new MoveDownBehavior());
                    moveDown();
                }
                if (distance > 0) {
                    distance -= SPEED;
                }
                timeCountMove = 0;
            }
        }else {
            timeCountMove += Game.GAME_LOOP_TIME;
            if (timeCountMove >= DELAY_MOVE_MAX) {
                if (distance < DISTANCE_MAX) {
                    distance += SPEED;
                }
            }
        }
    }

    @Override
    public void run() {
        super.run();
        // set move (Nhận xem move bên nào)
        move();
        //move
//        if (moveBehavior != null) {
//            moveBehavior.move(this);
//        }
//        setMoveBehavior(null);

        // set shoot (Nhận xem move bên nào)
        shoot();
        if (timeCount < TIME_DELAY_SHOOT) {
            timeCount += Game.GAME_LOOP_TIME;
        }
        encreaseBullet();

        // Nếu bắn đủ số đạn rồi thì không bắn nữa
        if (shootBehavior != null) {
            shootBehavior.shoot(this);
        }
    }

    // Set khi bắn
    public void shoot() {
        if (bitSet.get(PlayScene.LEFT_P2)) {
            if (angle <= 240) {
                angle += ANGLE_CHANGE;
            }

        }
        if (bitSet.get(PlayScene.RIGHT_P2)) {
            if (angle >= 110) {
                angle -= ANGLE_CHANGE;
            }
        }

        if (bitSet.get(PlayScene.SHOOT_P2)) {
            shootNormal();
        }
    }

    public void shootNormal() {
        // Tăng time kể từ lần bắn trước
        if (timeCount >= TIME_DELAY_SHOOT && numBullet > 0) {      // Đủ time bắn
            // set lại
            timeCount = 0;
            timeEncreaseBullet = 0;
            numBullet--;
            // Bắn
            BulletController2 bulletController2 = new BulletController2((int) this.getX() - DEFAULT_WIDTH / 2 + 31, this.getMidY() - BulletModel2.DEFAULT_HEIGHT / 2, angle);
            ((BulletModel2) bulletController2.getModel()).setMoveBehavior(new MoveRightHeroBehavior());
            bullet.add(bulletController2);
        }
    }

}