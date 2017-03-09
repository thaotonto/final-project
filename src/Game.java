
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * Created by Thaotonto on 3/9/2017.
 */
public class Game extends Frame {


    public Game() throws IOException {
        setVisible(true);
        setSize(1366, 700);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

    }

}
