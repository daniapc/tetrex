import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
    
    private int width;
    private int height;

    private int fps = 24;

    Thread gameThread;

    private KeyManager keyListener = new KeyManager();

    public GamePanel(int w, int h){
        width = w;
        height = h;
        this.setPreferredSize(new Dimension (width, height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyListener);
        this.setFocusable(true);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public static char keyPressed (){
          }

    public void run (){
        
        double drawInterval = 1000000000/fps;
        double deltaTime = 0;
        long lastTime = System.nanoTime();
        long currentTime = 0;
        
        while (gameThread != null){
     
            currentTime += System.nanoTime();

            deltaTime += (currentTime - lastTime)/drawInterval;

            lastTime = currentTime;

            if (deltaTime >= 1){
                
                Game.update();

                //draw();
                deltaTime--;
            }
        }
    }



    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);

        g2d.fillRect(50, 75, 100, 250);

        g2d.dispose();
    }




}