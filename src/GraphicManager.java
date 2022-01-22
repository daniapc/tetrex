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

    /* Calls the game panel to start the loop */
    public static void startLoop(){
        gamePanel.gameLoop();
    }
}