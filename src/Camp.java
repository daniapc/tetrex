
/*Camp of the Tetris game */
public class Camp {
    private int height, width; //height and width of the camp
    private int[][] camp; //camp matrix, where 0 means empty, and other numbers mean occupied. Each number has a color associated with it

    public Camp(int height, int width) {
        this.height = height;
        this.width = width;
        this.camp = new int[height][width];
        
        /* Filling the camp with empty values */
        for(int i = 0; i < height;i++) 
        {
            for(int j = 0; j<width;j++)
            {
                this.camp[i][j]=0;
            }
        }
    }

    //updates and lowers blocks, if needed, when called
    public void UpdateCamp()
    {
        for(int line=0;line<height;line++)
        {
            if(IsLineFull(line))
            {
                LowerToLine(line);
            }
        }
    }

    /*returns true if location on Camp is occupied, false if not */
    public boolean IsOccupied(int x, int y)
    {
        //tests if it is on the bounderies of the camp.
        if (!IsInBounderies(x,y))
        {
            System.out.printf("\nError, x: %d and y: %d are out of bounderies of Camp\n",x,y);
            System.exit(1);
            return false;
        }
        return ( camp[y][x] == 0 ? false : true);
    }
    //getter
    public int GetHeight(){ return height; }
    public int GetWidth(){ return width; }

    //returns true if location is inside of Camp
    public boolean IsInBounderies(int x, int y)
    {
        if(x<0 ||x>= width || y<0 || y>= height)
            return false;
        return true;
    }
    

    private boolean IsLineFull(int line)
    {
        //tests if line is in the camp's bounderies
        if(line < height && line>=0)
        {
            //tests if one of the spaces in one line is empty
            for(int c : camp[line])
            {
               if (c==0)
               {
                    return false;
               }
                    
            }
            return true;
        }
        else
        {
        System.out.printf("\nError, line %d is out of bounderies of Camp.\n", line);
        System.exit(1);
        return false;
        }
    }

    private void RemoveLine(int line)
    {
        if(line>=0 && line<height)
        {
            //empty line
            for(int x =0;x<width;x++)
            {
                camp[line][x]=0;
            }
        }
        else
        {
        System.out.printf("\nError, line %d is out of bounderies of Camp.\n", line);
        System.exit(1);
        }
    }

    //Lowers every block above line by one
    private void LowerToLine(int line)
    {
        if(line < height && line>=0)
        {
                //lowers every block above line by one in Camp, letting y=0 be the top and y= height-1 be the bottom of the camp
                for(int y= line;y>0;y--)
                {
                    for(int x = 0; x<width;x++)
                    {
                        camp[y][x]=camp[y-1][x];
                    }
                }
                //empty line 0;
                RemoveLine(0);
        }
        else
        {
        System.out.printf("\nError, line %d is out of bounderies of Camp.\n", line);
        System.exit(1);
        }
    }

    public void CreateBlock(int x, int y, int color)
    {
        if(!IsOccupied(x, y))
        {
            camp[y][x]=color;
        }
    }

    /*tests if piece in said format fits on said position inside camp, id =0 is current format, else next Format*/
    public boolean ValidPosition (Piece piece, Coordinate position, int id)
    {
    
        int[][] form = (id==0? piece.GetFormat().GetCurrentRotationFormat() : piece.GetFormat().GetNextRotationFormat());
        int dim = piece.GetFormat().GetDimension();
        Coordinate mid = piece.GetFormat().GetMiddle();
        for(int i = 0; i<dim;i++)            {
            for(int j =0; j<dim;j++)
            {
               if(form[i][j]!=0 && (!IsInBounderies(j-mid.x+position.x, i-mid.y+position.y)
                || IsOccupied(j-mid.x+position.x, i-mid.y+position.y)))
               {
                   return false;
               }
            }
        }
        return true;
    }
    //makes current piece become part of camp
    public void PieceToCamp(Piece piece)
    {
        //gets information about piece
        Format format = piece.GetFormat();
        int[][] form = format.GetCurrentRotationFormat();
        int dim = format.GetDimension();
        Coordinate mid = format.GetMiddle(), position = piece.GetPosition();
        
        //for each block of the piece, tries to create a block on the expected position in the camp matrix, if position is valid
        if(ValidPosition(piece, position,0))
        {
            for(int i = 0; i<dim;i++)
            {
                for(int j =0; j<dim;j++)
                {
                    if(form[i][j]!=0)
                    {
                        CreateBlock(position.x-mid.x+j, position.y-mid.y+i, form[i][j]);
                    }
                }
            }
        }
        else
        {
            System.out.printf("\nError, position (%d,%d) is not valid on camp\n",position.x,position.y);
            System.exit((1));
        }
        
    }
}