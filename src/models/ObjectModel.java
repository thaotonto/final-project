package models;

/**
 * Created by Thaotonto on 3/12/2017.
 */
public class ObjectModel extends GameModel {
    // Kích thước mặc định
    public static final int DEFAULT_WIDTH = 100  ;
    public static final int DEFAULT_HEIGHT = 100 ;
    // speed mặc định
    public static final int SPEED = 5;
    // Dùng speed này
    private int speed ;

    public ObjectModel(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
