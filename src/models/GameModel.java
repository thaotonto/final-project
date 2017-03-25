package models;

import controllers.PlayerController2;
import gamemain.gamescene.MenuScene;
import utils.Utils;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.awt.*;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class GameModel {
    public static final int HP_MAX = 100;
    protected float x;
    protected float y;
    protected int width;
    protected int height;

    protected int hp;
    protected boolean isAlive;

    public GameModel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getMidX() {
        return ((int) (x + width / 2));
    }

    public int getMidY() {
        return ((int) (y + height / 2));
    }

    public void run() {
    }

    public Rectangle getRect() {
        return (new Rectangle((int) x, (int) y, width, height));
    }

    public void getHit() {
        if (this instanceof PlayerModel) {
            Clip clip = Utils.playSound("resources/Angry-chicken.wav",false);
            clip.setMicrosecondPosition(500000);
            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-5.0f);
            clip.start();
        }
        this.hp -= BulletModel.DAMAGE;
        if (hp <= 0) {
            isAlive = false;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
