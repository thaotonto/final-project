package models;

import begavior.move.*;

import java.awt.event.KeyEvent;
import java.util.BitSet;

/**
 * Created by TrKaJv on 10-Mar-17.
 */
public class PlayerModel extends GameModelCanMove{
    public static final int DEFAULT_WIDTH = 70;
    public static final int DEFAULT_HEGHT = 100;

    BitSet bitSet ;
    public PlayerModel(int x, int y, int width, int height, BitSet bitSet) {
        super(x, y, width, height);
        this.bitSet = bitSet;
    }

    @Override
    public void move() {
        if(bitSet.get(KeyEvent.VK_UP)){
            setMoveBehavior(new MoveUpBehavior());
        }
        if(bitSet.get(KeyEvent.VK_DOWN)){
            setMoveBehavior(new MoveDownBehavior());
        }
        if(bitSet.get(KeyEvent.VK_LEFT)){
            setMoveBehavior(new MoveLeftBehavior());
        }
        if(bitSet.get(KeyEvent.VK_RIGHT)){
            setMoveBehavior(new MoveRightBehavior());
        }


        if(bitSet.get(KeyEvent.VK_UP) && bitSet.get(KeyEvent.VK_RIGHT)){
            setMoveBehavior(new MoveUpRightBehavior());
        }
        if(bitSet.get(KeyEvent.VK_UP) && bitSet.get(KeyEvent.VK_LEFT)){
            setMoveBehavior(new MoveUpLeftBehavior());
        }

        if(bitSet.get(KeyEvent.VK_DOWN) && bitSet.get(KeyEvent.VK_LEFT)){
            setMoveBehavior(new MoveDownLeftBehavior());
        }

        if(bitSet.get(KeyEvent.VK_DOWN) && bitSet.get(KeyEvent.VK_RIGHT)){
            setMoveBehavior(new MoveDownRightBehavior());
        }
    }

    @Override
    public void run() {
        move();
        super.run();
        setMoveBehavior(null);
    }
}
