import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GraphicManager {
    private static JFrame window; //= new JFrame();

    private static GamePanel gamePanel;

    public GraphicManager(){
        
    }

    /* Almost all the methods  of this class are static */

    /* Responsable to create the window and the camePanel class which is an object of the Graphic Manager*/
    public static void setupGraphics(int width, int height){
        window = new JFrame();
        
        gamePanel = new GamePanel(width,height);

        window.setSize(width, height);
        window.setTitle("Drawing in Java");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        window.add(gamePanel);
    }

    // 0 = up, 1 = down, 2 = right, 3 = left
    public static void keysPressed(boolean[] keys){
        gamePanel.keysPressed(keys);
    }

    /* Calls the game panel to start running the thread */
    public static void startLoop(){
        gamePanel.run();
    }

    public static void updatePositions(int posX, int posY){
        gamePanel.setPositions(posX, posY);
    }
}