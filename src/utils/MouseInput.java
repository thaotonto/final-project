package utils;

import gamemain.Game;
import views.GameMenuView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by EDGY on 3/15/2017.
 */
public class MouseInput implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*
        private Rectangle playButton = new Rectangle(450,225,300,100);
        private Rectangle optionButton = new Rectangle(450,350,300,100);
        private Rectangle quitButton = new Rectangle(450,475,300,100);
         */
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(mouseX >= 450 && mouseX <= 750){
            if(mouseY >= 225 && mouseY <= 325){
                Game.menuType = GameMenuView.MenuType.START;

            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
