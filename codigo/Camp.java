/*Camp of the Tetris game */
public class Camp {
    private int height, width; //height and width of the camp
    private char[][] camp; //camp matrix, where 0 means empty, and other numbers mean occupied. Each number has a color associated with it
    
    public Camp(int height, int width) {
        this.height = height;
        this.width = width;
        this.camp = new char[height][width];
        
        /* Filling the camp with empty values */
        for(int i = 0; i < height;i++) 
        {
            for(int j = 0; j<width;j++)
            {
                this.camp[i][j]=0;
            }
        }
    }
    /*returns true if location on Camp is occupied, false if not */
    public boolean isOccupied(int x, int y)
    {
        //tests if it is on the bounderies of the camp.
        if (isInBounderies(x, y))
        {
            System.out.printf("Error, x: %d and y: %d are out of bounderies of Camp\nline 25, Camp.java\n\n",x,y);
            System.exit(1);
            return false;
        }
        return ( camp[x][y] == 0 ? false : true);
    }
    public boolean isInBounderies(int x, int y)
    {
        if(x<0 ||x>= width || y<0 || y>= height)
            return false;
        return true;
    }

}
