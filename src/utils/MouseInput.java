package utils;

import gamemain.GameFrame;
import gamemain.GameMenu;

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
        private Rectangle playButton = new Rectangle(450,175,300,100);
        private Rectangle optionButton = new Rectangle(450,300,300,100);
        private Rectangle quitButton = new Rectangle(450,425,300,100);
         */
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println("x : "+mouseX +"--- y : " +mouseY );
        if(mouseX >= 450 && mouseX <= 750){
            if(mouseY >= 175 && mouseY <= 275){
                GameFrame.menuType = GameMenu.MenuType.START;

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
