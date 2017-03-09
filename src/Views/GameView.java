package Views;

import Models.GameModel;

import java.awt.*;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class GameView {
    protected Image image;

    public GameView(Image image) {
        this.image = image;
    }

    public void draw(Graphics graphics, GameModel model){
        graphics.drawImage(image,model.getX(), model.getY(), model.getWidth(), model.getHeight(),null);
    }
}
