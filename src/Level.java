public class Level {

    private Piece piece; 

    // Movimentação das peças, sujeito a alterações
    private int speed = 1;
    private int positionX = 100, positionY = 100;
    

    public Level (){

    }

    public void update (){
        this.move();
    }

    // Temporário, provável que esse movimento pertença à peça, então sujeito a mudanças
    public void move (){
        
        // 0 = up, 1 = down, 2 = right, 3 = left
        boolean[] keys = {false, false, false, false};

        GraphicManager.keysPressed(keys);

        if (keys[0]){ // up pressed = true
            positionY -= speed;
        }
        if (keys[1]){ // down pressed = true
            positionY += speed;
        }
        if (keys[2]){ // right pressed = true
            positionX += speed;
        }
        if (keys[3]){ // left pressed = true
            positionX -= speed;
        }
        
        GraphicManager.updatePositions(positionX, positionY);
    }


}