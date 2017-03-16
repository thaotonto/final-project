package views;

import gamemain.Game;
import models.GameModel;

import java.awt.*;

/**
 * Created by EDGY on 3/15/2017.
 */
public class GameMenuView{
    private Rectangle playButton = new Rectangle(450,225,300,100);
    private Rectangle optionButton = new Rectangle(450,350,300,100);
    private Rectangle quitButton = new Rectangle(450,475,300,100);

    public void draw(Graphics graphics){
        Graphics2D g2d = (Graphics2D)graphics;
        Font font = new Font("Arial",Font.BOLD,50);
        graphics.setFont(font);
        graphics.setColor(Color.blue);
        graphics.drawString("NEW GAME",450, 100);
        g2d.draw(playButton);
        g2d.draw(optionButton);
        g2d.draw(quitButton);
    }

    public enum MenuType{
        START,
        QUIT,
        OPTION,
        HOME
    }
}
