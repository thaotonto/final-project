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
    public PlayerModel2(int x, int y, int width, int height, BitSet bitSet, Vector<GameController> bullet) {
        super(x, y, width, height, bitSet, bullet);
        this.speed = SPEED;
        this.hp = 100;
        angle = 180;
    }
    // Xác định move theo hướng nào
    @Override
    public void move() {
        if (bitSet.get(PlayScene.UP_P2)) {
            setMoveBehavior(new MoveUpBehavior());
        }
        if (bitSet.get(PlayScene.DOWN_P2)) {
            setMoveBehavior(new MoveDownBehavior());
        }
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
        if (timeCount < TIME_DELAY_SHOOT) {
            timeCount += Game.GAME_LOOP_TIME;
        }
        timeEncreaseBullet +=Game.GAME_LOOP_TIME;
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
        if (timeCount >= TIME_DELAY_SHOOT && numBullet>0) {      // Đủ time bắn
            // set lại
            timeCount = 0;
            timeEncreaseBullet = 0;
            numBullet--;
            // Bắn
            BulletController2 bulletController2 = new BulletController2((int) this.getX() - DEFAULT_WIDTH/2 + 31, this.getMidY() - BulletModel2.DEFAULT_HEIGHT/2, angle);
            ((BulletModel2) bulletController2.getModel()).setMoveBehavior(new MoveRightHeroBehavior());
            bullet.add(bulletController2);
        }
    }

}