import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Principal {
    public static void main (String[] args){
        final int W = 640;
        final int H = 480;
        JFrame f = new JFrame();
    
        DrawingCanvas dc = new DrawingCanvas(W,H);
        f.setSize(W, H);
        f.setTitle("Drawing in Java");
        f.add(dc);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

}