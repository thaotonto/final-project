package views;

import models.GameModel;
import models.PlayerInforModel;
import models.PlayerModel;

import java.awt.*;

/**
 * Created by TrKaJv on 22-Mar-17.
 */
public class PlayerInforView extends GameView {
    public PlayerInforView(Image image) {
        super(image);
    }

    @Override
    public void draw(Graphics2D graphics, GameModel gameModel) {
        if(gameModel instanceof PlayerInforModel){
            // set font stroke
            BasicStroke basicStroke = new BasicStroke(1,BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
            (graphics).setStroke(basicStroke);
            graphics.setFont(new java.awt.Font("Britannic",-1, 12));

            // Border
            graphics.setColor(new Color(0, 255, 8));
            graphics.drawRect((int) gameModel.getX(), (int)gameModel.getY(), gameModel.getWidth(),  gameModel.getHeight());

            // HP
            graphics.setColor(new Color(255, 18, 0));
            graphics.drawString("HP", gameModel.getX()+20, gameModel.getY()+20);
            graphics.fillRect( (int)gameModel.getX()+50,(int) gameModel.getY()+10, ((PlayerInforModel)gameModel).getHPLeght(), 10);
            graphics.drawRect((int) gameModel.getX()+50,(int) gameModel.getY()+10, PlayerInforModel.DEFAULT_WIDTH_HP, 10);

            // MANA
            graphics.setColor(new Color(9, 19, 255));
            graphics.drawString("MANA", gameModel.getX()+3, gameModel.getY()+40);
            graphics.fillRect( (int)gameModel.getX()+50, (int)gameModel.getY()+30, ((PlayerInforModel)gameModel).getTimeCanShoot(), 10);
            graphics.drawRect( (int)gameModel.getX()+50, (int)gameModel.getY()+30, PlayerInforModel.DEFAULT_WIDTH_HP, 10);

            // NUM_BULLET
            graphics.setColor(new Color(255, 250, 35));
            graphics.drawString("NUM BUL", gameModel.getX(), gameModel.getY()+60);
//            graphics.drawString(((PlayerInforModel) gameModel).getPlayerModel().getArmor()+"", gameModel.getX()+60, gameModel.getY()+40);
        }
    }
}
