package models;

/**
 * Created by TrKaJv on 25-Mar-17.
 */
public class ExplodeModel extends  GameModel {
    boolean checkExployde = false;

    public boolean isCheckExployde() {
        return checkExployde;
    }

    public void setCheckExployde(boolean checkExployde) {
        this.checkExployde = checkExployde;
    }

    public ExplodeModel(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
