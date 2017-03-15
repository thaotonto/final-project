package gamemain;

import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by KhoaBeo on 3/9/2017.
 */
public class GameOverPanel extends JPanel {

    private Image image;
    private int width = 500;
    private int height = 359;
    private JLabel btnexit;

    public GameOverPanel(Image image) {
        setLayout(null);
        initComp();
        this.image = image;
    }

    private void initComp() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (mouseEvent.getSource().equals(btnexit)) {
                    System.exit(0);
                }
            }
        };
        ImageIcon icon = new ImageIcon("resources/Menu.png");
        btnexit = new JLabel(icon);
        btnexit.setBounds(GameFrame.FRAME_WIDTH / 2 + 50 , GameFrame.FRAME_HEIGHT / 2 + 55  , icon.getIconWidth(), icon.getIconHeight());
        btnexit.setFocusable(false);
        add(btnexit);
        btnexit.addMouseListener(mouseAdapter);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Image image = Utils.loadImageFromres("BG.png");
        graphics.drawImage(image, 0, 0, GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT, null);
        graphics.drawImage(this.image, (GameFrame.FRAME_WIDTH / 2 - width / 2), (GameFrame.FRAME_HEIGHT / 2 - height / 2), width, height, null);
    }
}
