package models;

/**
 * Created by TrKaJv on 25-Mar-17.
 */
public class ExplodeModel extends  GameModel {
<<<<<<< HEAD
    public static final int DEFAULT_WIDTH = 60;
    public static final int DEFAULT_HEIGHT = 60;
=======
    boolean checkExployde = false;

    public boolean isCheckExployde() {
        return checkExployde;
    }

    public void setCheckExployde(boolean checkExployde) {
        this.checkExployde = checkExployde;
    }

>>>>>>> 818c64d404506ed3060263d418fb76dac1b4b2bc
    public ExplodeModel(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
