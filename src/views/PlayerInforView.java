package views;

import models.GameModel;
import models.PlayerInforModel;
import models.PlayerModel;

import java.awt.*;

/**
 * Created by TrKaJv on 22-Mar-17.
 */
public class PlayerInforView extends GameView {
    public static final int START_DRAW_INFOR = 60;
    public static final int PIXCEL_OF_CHAR = 8;
    public static final int HEIGHT_LINE = 10;

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
            String inforString = "HP";
            graphics.setColor(new Color(255, 18, 0));
            graphics.drawString(inforString, gameModel.getX()+(START_DRAW_INFOR-(inforString.length()*PIXCEL_OF_CHAR))/2, gameModel.getY()+20);
            graphics.fillRect( (int)gameModel.getX()+START_DRAW_INFOR,(int) gameModel.getY()+10, ((PlayerInforModel)gameModel).getHPLeght(), HEIGHT_LINE);
            graphics.drawRect((int) gameModel.getX()+START_DRAW_INFOR,(int) gameModel.getY()+10, PlayerInforModel.DEFAULT_WIDTH_HP, HEIGHT_LINE);
            graphics.setColor(new Color(0, 0, 0));
            graphics.drawString(((PlayerInforModel) gameModel).getHP()+"", gameModel.getX()+START_DRAW_INFOR, gameModel.getY()+20);

            // MANA
             inforString = "DISTANCE";
            graphics.setColor(new Color(9, 19, 255));
            graphics.drawString(inforString,  gameModel.getX()+(START_DRAW_INFOR-(inforString.length()*PIXCEL_OF_CHAR))/2, gameModel.getY()+40);
            graphics.fillRect( (int)gameModel.getX()+START_DRAW_INFOR, (int)gameModel.getY()+30, ((PlayerInforModel)gameModel).getDistance(), HEIGHT_LINE);
            graphics.drawRect( (int)gameModel.getX()+START_DRAW_INFOR, (int)gameModel.getY()+30, PlayerInforModel.DEFAULT_WIDTH_HP, HEIGHT_LINE);

            // NUM_BULLET
            inforString = "NUM BUL";
            graphics.setColor(new Color(255, 150, 0));
            graphics.drawString(inforString,  gameModel.getX()+(START_DRAW_INFOR-(inforString.length()*PIXCEL_OF_CHAR))/2, gameModel.getY()+60);
            graphics.fillRect( (int)gameModel.getX()+START_DRAW_INFOR, (int)gameModel.getY()+50, ((PlayerInforModel)gameModel).getNumBullet()*(PlayerInforModel.DEFAULT_WIDTH_HP/PlayerModel.NUM_BULLET_MAX), 10);

            graphics.setColor(new Color(0, 0, 0));
            graphics.drawRect( (int)gameModel.getX()+START_DRAW_INFOR, (int)gameModel.getY()+50, PlayerInforModel.DEFAULT_WIDTH_HP, HEIGHT_LINE);
            for(int i = 0; i<PlayerModel.NUM_BULLET_MAX; i++){
                graphics.fillRect( (int)(gameModel.getX()+START_DRAW_INFOR+i*(PlayerInforModel.DEFAULT_WIDTH_HP/(float)PlayerModel.NUM_BULLET_MAX)), (int)gameModel.getY()+50, 2, HEIGHT_LINE);
            }
        }
    }
}