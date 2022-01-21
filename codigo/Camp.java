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
        if (!isInBounderies(x, y))
        {
            System.out.printf("\nError, x: %d and y: %d are out of bounderies of Camp\n",x,y);
            System.exit(1);
            return false;
        }
        return ( camp[y][x] == 0 ? false : true);
    }
    //returns true if location is inside of Camp
    public boolean isInBounderies(int x, int y)
    {
        if(x<0 ||x>= width || y<0 || y>= height)
            return false;
        return true;
    }


    //Try to remove line if it is filled and lower other lines when needed
    private void TryToRemoveLine(int line)
    {
        boolean isFull = true;//flag to store if the statement: "line is full", is true
        //tests if line is in the camp's bounderies
        if(isInBounderies(0, line))
        {
            //tests if one of the spaces in one line is empty
            for(char c : camp[line])
            {
               if (c==0)
               {
                    isFull = false;
                    break;
               }
                    
            }
            //Removes a line if it is full
            if(isFull)
            {
                //lowers every block by one in Camp, letting y=0 be the top and y= height-1 be the bottom of the camp
                for(int y= line;y>0;y--)
                {
                    for(int x = 0; x<width;x++)
                    {
                        camp[y][x]=camp[y-1][x];
                    }
                }
                //empty line 0;
                for(int x =0;x<width;x++)
                {
                    camp[0][x]=0;
                }
            }
        }
        System.out.printf("\nError, line %d is out of bounderies of Camp.\n", line);
        System.exit(1);
    }
}
