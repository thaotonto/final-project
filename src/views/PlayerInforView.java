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
            BasicStroke basicStroke = new BasicStroke(1,BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
            (graphics).setStroke(basicStroke);
            graphics.setFont(new java.awt.Font("Britannic",-1, 12));


            graphics.setColor(new Color(0, 255, 8));
            graphics.drawRect((int) gameModel.getX(), (int)gameModel.getY(), gameModel.getWidth(),  gameModel.getHeight());

            graphics.setColor(new Color(255, 18, 0));
            graphics.drawString("HP", gameModel.getX()+20, gameModel.getY()+20);
            graphics.fillRect( (int)gameModel.getX()+50,(int) gameModel.getY()+10, ((PlayerInforModel)gameModel).getHPLeght(), 10);
            graphics.drawRect((int) gameModel.getX()+50,(int) gameModel.getY()+10, PlayerInforModel.DEFAULT_WIDTH_HP, 10);

            graphics.setColor(new Color(9, 19, 255));
            graphics.drawString("MANA", gameModel.getX()+3, gameModel.getY()+40);
            graphics.fillRect( (int)gameModel.getX()+50, (int)gameModel.getY()+30, ((PlayerInforModel)gameModel).getTimeCanShoot(), 10);
            graphics.drawRect( (int)gameModel.getX()+50, (int)gameModel.getY()+30, PlayerInforModel.DEFAULT_WIDTH_HP, 10);

            graphics.setColor(new Color(0, 0, 0));
            graphics.drawString(((PlayerInforModel) gameModel).getPlayerModel().getHp()+"", gameModel.getX()+60, gameModel.getY()+20);
//            graphics.drawString(((PlayerInforModel) gameModel).getPlayerModel().getArmor()+"", gameModel.getX()+60, gameModel.getY()+40);
        }
    }
}
