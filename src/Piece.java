public class Piece {
    private Coordinate position; //position of the piece
    private Format format; //format and color of the piece
    private Camp camp; //Address to Camp Object

    public Piece(Coordinate position, Format format) {
        this.position = position;
        this.format = format;
        this.format.ZeroRotation();
    }
    // moves piece to postion, without testing it
    public void MoveTo(Coordinate position)
    {
        this.position = position;
    }
    //tests if piece fits on said position
    public boolean ValidPosition (Coordinate position, int[][] form)
    {

        int dim = format.GetDimension();
        Coordinate mid = format.GetMiddle();
        for(int i = 0; i<dim;i++)
        {
            for(int j =0; j<dim;j++)
            {
               if(form[i][j]!=0 && (!camp.IsInBounderies(j-mid.x+position.x, i-mid.y+position.y)
                || camp.IsOccupied(j-mid.x+position.x, i-mid.y+position.y)))
               {
                    return false;
               }
            }
        }
        return true;
    }
}
