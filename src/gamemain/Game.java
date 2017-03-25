package gamemain;

import gamemain.gamescene.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.util.Stack;


/**
 * Created by Thaotonto on 3/9/2017.
 */
public class Game extends Frame implements Runnable,Subcriber{

    public static final int GAME_LOOP_TIME = 17;
    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 600;
    private GameScene currentScene;
    private Stack<GameScene> backStack;
    private BufferedImage backImage;
    private Graphics graphics;

    // Biến
    Thread loop;



    public Game() {


        // Thêm và khởi tạo các object abn đầu
        addObjectInit();
        // Thêm các event về phím và tắt màn hình
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setVisible(true);
        currentScene = new MenuScene();
        backStack = new Stack<>();
        addMouseListener(currentScene);
        addKeyListener(currentScene);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                    onBack();
                }
                if(e.getKeyCode() == KeyEvent.VK_R){
                    MenuScene.clip.stop();
                    NotificationCenter.getInstance().onChange(SceneType.PLAY_SCENE,false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        NotificationCenter.getInstance().register(this);
        //loop game
        loop.start();
    }

    public void onBack() {
        GameScene gameScene;
        if(backStack.size() > 0){
            gameScene = backStack.pop();
            attach(gameScene);
        }
    }

    public void detach(){
        if(currentScene != null){
            removeKeyListener(currentScene);
            removeMouseListener(currentScene);
        }
    }

    public void attach(GameScene gameScene){
        detach();
        currentScene = gameScene;
        addKeyListener(currentScene);
        addMouseListener(currentScene);
    }

    // Khởi tạo các đối tượng ban đầu
    private void addObjectInit() {
        backImage = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        graphics = backImage.getGraphics();
        loop = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(GAME_LOOP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentScene.run();
                }
            }
        });
    }

    @Override
    public void update(Graphics g) {
        currentScene.update(graphics);
        g.drawImage(backImage, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, null);
    }

    //    @Override
//    protected void paintComponent(Graphics graphics) {
//        currentScene.update(graphics);
//        System.out.println("ac");
//        super.paintComponent(graphics);
//    }

    @Override
    public void run() {

    }

    @Override
    public void onChange(SceneType sceneType, boolean addToBackStack) {
       if(addToBackStack){
           backStack.add(currentScene);
       }
       switch (sceneType){
           case MENU_SCENE:
               attach(new MenuScene());
               break;

           case GUIDE_SCENE:
               attach(new GuideScene());
               break;

           case PLAY_SCENE:
               attach(new PlayScene());
               break;

           case GAMEOVER_SCENE:
               attach(new GameOverScene());
               break;
       }
    }
}
