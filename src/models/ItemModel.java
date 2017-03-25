package models;

/**
 * Created by EDGY on 3/24/2017.
 */
public class ItemModel extends GameModel{
    private static final int TIME_ALIVE = 100;
    private static final int DEFAULT_WIDTH = 30;
    private static final int DEFAULT_HEIGHT = 30;

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
