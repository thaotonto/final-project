package gamemain;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class Main {
    public static Game gameFrame;
    public static void main (String[] args){
        gameFrame = new Game();
        System.out.println("        ESC        : out game");
        System.out.println("LEFT_RIGHT_UP_DOWN : move player game");
        System.out.println("         C         : skip turn");
    }
}
