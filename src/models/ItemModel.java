package models;

/**
 * Created by EDGY on 3/24/2017.
 */
public class ItemModel extends GameModel{
    private static final int TIME_ALIVE = 100;
    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 50;

    public ItemModel(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void run() {

    }

    public enum ItemType{
        HP_REGEN,
        SHELD,
        SLOW
    }
}
