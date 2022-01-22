import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/*Main class */
public class Game {
    
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    //private static GraphicManager graphicManager = new GraphicManager();
    
    public static void main (String[] args){
        
        GraphicManager.setupGraphics(WIDTH, HEIGHT);

        GraphicManager.startLoop();

        //JFrame window = new JFrame();
    



    }

}