package models;

import gamemain.Game;

/**
 * Created by TrKaJv on 11-Mar-17.
 */
public interface GameModelCanMove {
    public void move();

    public void moveUp();

    public void moveDown() ;

    public void moveLeft();

    public void moveRight();

    public void smartMove();

}
