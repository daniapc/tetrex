import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

    private boolean up, down, left, right;

    public void keyTyped (KeyEvent  event){


    }

    public void keyPressed (KeyEvent  event){
        int code = event.getKeyCode();

        if (code == KeyEvent.VK_W)
            up = true;
        if (code == KeyEvent.VK_S)
            down = true;
        if (code == KeyEvent.VK_A)
            left = true;
        if (code == KeyEvent.VK_D)
            up = true;

    }

    public void keyReleased (KeyEvent event){ 
        int code = event.getKeyCode();

        if (code == KeyEvent.VK_W)
            up = false;
        if (code == KeyEvent.VK_S)
            down = false;
        if (code == KeyEvent.VK_A)
            left = false;
        if (code == KeyEvent.VK_D)
            right = false;
    }

    public boolean getUp(){ return up; }
    public boolean getDown(){ return down; }
    public boolean getRight(){ return right; }
    public boolean getLeft(){ return left; }

}