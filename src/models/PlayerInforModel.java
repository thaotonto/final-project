package models;

/**
 * Created by TrKaJv on 22-Mar-17.
 */
public class PlayerInforModel extends GameModel {
    public static final int DEFAULT_WIDTH = 205;
    public static final int DEFAULT_HEIGHT = 50;

    public static final int DEFAULT_WIDTH_HP = DEFAULT_WIDTH-55;

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

    public int getTimeCanShoot(){
        return (int)(playerModel.getTimeCount()*(DEFAULT_WIDTH_HP/(float)PlayerModel.TIME_DELAY_SHOOT));
    }
}
