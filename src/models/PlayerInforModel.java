package models;

import views.PlayerInforView;

/**
 * Created by TrKaJv on 22-Mar-17.
 */
public class PlayerInforModel extends GameModel {
    public static final int DEFAULT_WIDTH = 215;
    public static final int DEFAULT_HEIGHT = 75;

    public static final int DEFAULT_WIDTH_HP = DEFAULT_WIDTH- PlayerInforView.START_DRAW_INFOR-5;

    private PlayerModel playerModel;

    public PlayerInforModel(int x, int y, int width, int height, PlayerModel model) {
        super(x, y, width, height);
        this.playerModel = model;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public int getHPLeght(){
        return (int)(playerModel.getHp()*(DEFAULT_WIDTH_HP/(float)100));
    }

    public int getDistance(){
        return (int)(playerModel.getDistance()*(DEFAULT_WIDTH_HP/(float)PlayerModel.DISTANCE_MAX));
    }

    public int getNumBullet() {
        return playerModel.getNumBullet();
    }

    public int getHP() {
        return playerModel.getHp();
    }
}
