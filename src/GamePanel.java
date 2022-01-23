import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
    
    private int width;
    private int height;

    // Temporário
    private int positionX = 100, positionY = 100;

    private int fps = 60;

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

    // 0 = up, 1 = down, 2 = right, 3 = left
    public void keysPressed(boolean[] keys){
        if (keyListener.getUp()) { keys[0] = true; }
        if (keyListener.getDown()) { keys[1] = true; }
        if (keyListener.getRight()) { keys[2] = true; }
        if (keyListener.getLeft()) { keys[3] = true; }
    }

    public void run (){
        
        double drawInterval = 1000000000/fps;
        double deltaTime = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while (gameThread != null){
     
            currentTime = System.nanoTime();

            deltaTime += (currentTime - lastTime)/drawInterval;

            lastTime = currentTime;

            if (deltaTime >= 1){
                
                // Update the game 
                Game.update();
                 
                System.out.println(deltaTime);

                // Calls the draw method
                repaint();

                deltaTime--;
            }
        }
    }

    public void setPositions(int posX, int posY){
        positionX = posX;
        positionY = posY;
    }

    // Por enquanto apenas pinta o retângulo que se movimenta, sujeito a alterações
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white);

        g2d.fillRect(positionX, positionY, 100, 100);

        g2d.dispose();
    }




}