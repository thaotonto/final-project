package models;

import behavior.move.*;
import controllers.BulletController1;
import controllers.GameController;
import gamemain.Game;
import gamemain.gamescene.PlayScene;

import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Vector;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerModel1 extends PlayerModel {


    public PlayerModel1(int x, int y, int width, int height, BitSet bitSet, Vector<GameController> bullet) {
        super(x, y, width, height, bitSet, bullet);
        this.speed = SPEED;
        this.hp = 100;
        angle = 0;
    }

    // Xác định move theo hướng nào
    @Override
    public void move() {
        if (bitSet.get(PlayScene.UP_P1) || bitSet.get(PlayScene.DOWN_P1)) {
            if (distance>0) {

                if (bitSet.get(PlayScene.UP_P1)) {
//            setMoveBehavior(new MoveUpBehavior());
                    moveUp();
                }
                if (bitSet.get(PlayScene.DOWN_P1)) {
//            setMoveBehavior(new MoveDownBehavior());
                    moveDown();
                }
                if (distance > 0) {
                    distance -= SPEED;
                }
                timeCountMove = 0;
            }

        } else {
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
//        //move
//        if (moveBehavior != null) {
//            moveBehavior.move(this);
//        }
        setMoveBehavior(null);

        // set shoot (Nhận xem move bên nào)
        shoot();
        if (timeCount < TIME_DELAY_SHOOT) {
            timeCount += Game.GAME_LOOP_TIME;
        }
        encreaseBullet();

        if (shootBehavior != null) {
            shootBehavior.shoot(this);
        }
    }

    // Set khi bắn
    public void shoot() {
        if (bitSet.get(PlayScene.LEFT_P1)) {
            if (angle <= 70) {
                angle += ANGLE_CHANGE;
            }

        }
        if (bitSet.get(PlayScene.RIGHT_P1)) {
            if (angle >= -70) {
                angle -= ANGLE_CHANGE;
            }
        }

        if (bitSet.get(PlayScene.SHOOT_P1)) {
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
            // Tăng lượng đạn đã bắn
            // Bắn
            BulletController1 bulletController1 = new BulletController1((int) this.getX() + DEFAULT_WIDTH - 18, this.getMidY() - BulletModel.DEFAULT_HEIGHT / 2, angle);
            ((BulletModel1) bulletController1.getModel()).setMoveBehavior(new MoveLeftHeroBehavior());
            bullet.add(bulletController1);
        }
    }
}
