package gamemain;
import utils.MouseInput;
import javax.swing.*;
import java.awt.*;


/**
 * Created by EDGY on 3/15/2017.
 */
public class GameMenu extends JPanel{
    private Rectangle playButton = new Rectangle(450,175,300,100);
    private Rectangle optionButton = new Rectangle(450,300,300,100);
    private Rectangle quitButton = new Rectangle(450,425,300,100);
    private Image menuBackground;
    private JLabel btnStart;
    private JLabel btnQuit;


    public GameMenu(Image image){
        setLayout(null);
        initComp();
        this.menuBackground = image;
    }

    private void initComp(){
//        addMouseListener(new MouseInput());
        //start button
        ImageIcon icon = new ImageIcon("resources/startGame.png");
        btnStart = new JLabel(icon);
        btnStart.setBounds(450 , 175  , icon.getIconWidth(), icon.getIconHeight());
        btnStart.setFocusable(false);
        add(btnStart);

        //quit button
        icon = new ImageIcon("resources/quitgame.png");
        btnQuit = new JLabel(icon);
        btnQuit.setBounds(450 , 300  , icon.getIconWidth(), icon.getIconHeight());
        btnQuit.setFocusable(false);
        add(btnQuit);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D)graphics;
        Font font = new Font("Arial",Font.BOLD,50);
        graphics.setFont(font);
        graphics.setColor(Color.blue);
        graphics.drawString("NEW GAME",450, 100);
        ((Graphics2D) graphics).drawImage(this.menuBackground,0,0,menuBackground.getWidth(null),menuBackground.getHeight(null), null);
    }

    public void Start(JFrame frame, Game game) {

    }

    public enum MenuType{
        START,
        QUIT,
        OPTION,
        HOME
    }
}
