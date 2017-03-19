package gamemain;

import oracle.jrockit.jfr.JFR;
import utils.MouseInput;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by Thaotonto on 3/15/2017.
 */
public class GameFrame extends JFrame {
    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 600;
    private static Game game;
    private static GameOverPanel gameOverplayer1;
    private static GameOverPanel gameOverplayer2;
    private static GameMenu gameMenu;
    public static GameMenu.MenuType menuType = GameMenu.MenuType.HOME;

    public GameFrame() throws HeadlessException {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initPanels();
        setContentPane(gameMenu);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                if(mouseX >= 450 && mouseX <= 750){
                    if(mouseY >= 175 && mouseY <= 275){
                        setContentPane(game);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
        });
//        gameMenu.Start(this,game);
        setVisible(true);
    }

    private void initPanels() {
        game = new Game();
        gameMenu = new GameMenu(Utils.loadImageFromres("BackGroundStartGame.png"));
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
