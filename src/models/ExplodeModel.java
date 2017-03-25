package models;

/**
 * Created by TrKaJv on 25-Mar-17.
 */
public class ExplodeModel extends  GameModel {
    boolean checkExployde = true;

    public boolean isCheckExployde() {
        return checkExployde;
    }

    public void setCheckExployde(boolean checkExployde) {
        this.checkExployde = checkExployde;
    }
    public static final int  WIDTH_EPLOYDE = 60;
    public static final int  HEIGHT_EPLOYDE = 60;
    public ExplodeModel(int x, int y) {
        super(x, y, WIDTH_EPLOYDE, WIDTH_EPLOYDE);
    }
}
