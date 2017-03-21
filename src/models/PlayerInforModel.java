package models;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by TrKaJv on 22-Mar-17.
 */
public class PlayerInforModel extends GameModel {
    public static final int DEFAULT_WIDTH = 205;
    public static final int DEFAULT_HEIGHT = 50;
    private PlayerModel playerModel;

    public PlayerInforModel(int x, int y, int width, int height, PlayerModel model) {
        super(x, y, width, height);
        this.playerModel = model;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }


}
