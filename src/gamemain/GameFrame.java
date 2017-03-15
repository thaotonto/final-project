package gamemain;

import utils.Utils;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Thaotonto on 3/15/2017.
 */
public class GameFrame extends JFrame {
    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 600;
    private static Game game;
    private static GameOverPanel gameOverplayer1;
    private static GameOverPanel gameOverplayer2;

    public GameFrame() throws HeadlessException {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initPanels();
        setContentPane(game);
        setVisible(true);
    }

    private void initPanels() {
        game = new Game();
        gameOverplayer1 = new GameOverPanel(Utils.loadImageFromres("player-1-wins.png"));
        gameOverplayer2 = new GameOverPanel(Utils.loadImageFromres("player-2-wins.png"));
    }

    public void setGameOver(int player){
        if (player == 2) {
            setContentPane(gameOverplayer1);
        }
        if (player == 1) {
            setContentPane(gameOverplayer2);
        }
        setVisible(true);
    }

}
