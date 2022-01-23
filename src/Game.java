/*Main class */
public class Game {
    
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    // Não combina o fato do level ser estático, então sujeito a mudanças
    private static Level level = new Level();
    
    public static void main (String[] args){
        
        GraphicManager.setupGraphics(WIDTH, HEIGHT);

        GraphicManager.startLoop();

    }

    public static void update (){
        
        level.update();

    }

}