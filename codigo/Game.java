import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/*Main class */
public class Game {
    public static void main (String[] args){
        final int W = 640;
        final int H = 480;

        JFrame window = new JFrame();
    
        DrawingCanvas dc = new DrawingCanvas(W,H);
        window.setSize(W, H);
        window.setTitle("Drawing in Java");
        window.add(dc);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

}